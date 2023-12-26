package lk.ijse.layeredarchitecture.dao.custom;

import lk.ijse.layeredarchitecture.dao.crudDAO;
import lk.ijse.layeredarchitecture.dto.OrderDTO;
import lk.ijse.layeredarchitecture.dto.OrderDetailDTO;
import lk.ijse.layeredarchitecture.entity.Order;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public interface OrderDAO  extends crudDAO<Order> {
    //boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;
   /* String generateNextOrderId(String orderId) throws SQLException, ClassNotFoundException;

    //exit Orders
    boolean exitOrders(String orderId) throws SQLException, ClassNotFoundException;


    boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;*/
}
