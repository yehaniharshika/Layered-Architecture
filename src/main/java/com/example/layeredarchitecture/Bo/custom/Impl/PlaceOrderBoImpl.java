package com.example.layeredarchitecture.Bo.custom.Impl;

import com.example.layeredarchitecture.Bo.PlaceOrderBo;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.Impl.CustomerDAOImpl;
import com.example.layeredarchitecture.dao.custom.Impl.ItemDAOImpl;
import com.example.layeredarchitecture.dao.custom.Impl.OrderDAOImpl;
import com.example.layeredarchitecture.dao.custom.Impl.OrderDetailDAOImpl;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBoImpl implements PlaceOrderBo {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER_DETAILS);

    @Override
    public boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {


        /*Transaction*/
        Connection connection = null;


            connection = DBConnection.getDbConnection().getConnection();
           /* boolean existOrder = orderDAO.existOrder(orderId);

            if (existOrder) {
                return false;
            }

            boolean isSaved = orderDAO.saveOrder(orderId,orderDate,customerId,orderDetails);

            if (isSaved) {
                return true;
            }*/

            boolean exitOrder = orderDAO.exit(orderId);
            if (exitOrder) {
                return false;
            }

            connection.setAutoCommit(false);

            boolean isOrderDetail = orderDAO.saveOrder(orderId, orderDate, customerId, orderDetails);

            if (!isOrderDetail) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            boolean isOrderDetailsSaved = orderDetailDAO.saveOrderDetail(orderId, orderDetails);

            if (!isOrderDetailsSaved) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            for (OrderDetailDTO detail : orderDetails) {
                ItemDTO item = findItem(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                boolean isItemUpdated = itemDAO.update(item);
                if (!isItemUpdated) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;


        /*} catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;*/
    }
    @Override
    public ItemDTO findItem(String code) {
        try {
            return itemDAO.search(code);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.search(id);
    }

    @Override
    public ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException {
        return itemDAO.search(newItemCode);
    }

    @Override
    public String generateNextOrderId(String orderId) throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewId(orderId);
    }



    @Override
    public boolean exitCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exit(id);
    }

    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }

    @Override
    public boolean saveOrders(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        return orderDAO.saveOrder(orderId,orderDate, customerId,orderDetails);
    }
}
