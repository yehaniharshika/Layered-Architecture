package com.example.layeredarchitecture.dao.custom.Impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {

    @Override
    public boolean saveOrderDetail(String orderId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getDbConnection().getConnection();

        PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
*/
        for (OrderDetailDTO detail : orderDetails) {

            Object execute = SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",
                    orderId, detail.getItemCode(), detail.getUnitPrice(), detail.getQty());

            if (!(Boolean)execute) {
                return false;
            }

            /*stm.setString(1, orderId);
            stm.setString(2, detail.getItemCode());
            stm.setBigDecimal(3, detail.getUnitPrice());
            stm.setInt(4, detail.getQty());

            if (!(stm.executeUpdate() > 0)) {
                return false;
            }*/

            /*if (stm.executeUpdate() != 1) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            ItemDTO item = itemDAO.searchItem(detail.getItemCode());
            item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());
            boolean isUpdated = itemDAO.updateItem(item);

            if (!isUpdated) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }*/
        }
        // return true;
        return true;
    }

    /*public boolean saveAllCustomrOrderDetails(CustomerDTO dto, OrderDTO orderDTO,OrderDetailDTO orderdetails) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm= connection.prepareStatement("SELECT c.id,c.name,o.oid,o.date,od.itemCode,od.qty,od.unitPrice FROM Customer c JOIN Orders o ON c.id=o.customerID JOIN OrderDetails od ON o.oid = od.oid;");


        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
            resultSet.getString(dto.getId()),
            resultSet.getString(dto.getName()),
            resultSet.getString(orderDTO.getOrderId()),
            resultSet.getString(String.valueOf(orderDTO.getOrderDate())),
            resultSet.getString(orderdetails.getItemCode()),
            resultSet.getInt(orderdetails.getQty()),
            resultSet.getBigDecimal(String.valueOf(orderdetails.getUnitPrice()))
        }

        return false;
    }*/


    @Override
    public boolean save(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exit(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewId(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public OrderDetailDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }


    /*public boolean saveOrderDetails(List<OrderDetailDTO> orderDetails, String orderId) throws SQLException, ClassNotFoundException {
      *//*  Connection connection = DBConnection.getDbConnection().getConnection();
          PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
*//*
            boolean detailSaved = false;
            for (OrderDetailDTO detail : orderDetails) {

                detailSaved =  SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",
                        orderId, detail.getItemCode(), detail.getUnitPrice(), detail.getQty());

            }
            return detailSaved;

        }*/

        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");

        stm.setString(1,oid);
        stm.setString(2, dto.getItemCode());
        stm.setBigDecimal(3, dto.getUnitPrice());
        stm.setInt(4, dto.getQty());
        return stm.executeUpdate()>0;*/

       /* for (OrderDetailDTO detail : orderDetails) {
            stm.setString(1, orderId);
            stm.setString(2, detail.getItemCode());
            stm.setBigDecimal(3, detail.getUnitPrice());
            stm.setInt(4, detail.getQty());

            if (stm.executeUpdate() != 1) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }


            ItemDAOImpl itemDAO = new ItemDAOImpl();
                //Search Item
            ItemDTO item = itemDAO.searchItem(detail.getItemCode());
            item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

            //update Item
            boolean isUpdated = itemDAO.updateItem(item);

           *//* PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
            pstm.setString(1, item.getDescription());
            pstm.setBigDecimal(2, item.getUnitPrice());
            pstm.setInt(3, item.getQtyOnHand());
            pstm.setString(4, item.getCode());*//*

            if (!isUpdated) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
        }*/

       /* connection.commit();
        connection.setAutoCommit(true);
        return true;*/
        //return isOrderDetailSaved;

}
