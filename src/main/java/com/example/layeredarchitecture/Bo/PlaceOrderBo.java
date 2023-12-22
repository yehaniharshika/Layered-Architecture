package com.example.layeredarchitecture.Bo;

import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PlaceOrderBo {
    boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;
    ItemDTO findItem(String code);
    CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException;
    ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException;
    String generateNextOrderId(String orderId) throws SQLException, ClassNotFoundException;

    //exit Orders
    //boolean exitOrders(String orderId) throws SQLException, ClassNotFoundException;
    boolean exitCustomer(String id) throws SQLException, ClassNotFoundException;
    boolean existItem(String code) throws SQLException, ClassNotFoundException;

    List<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
    ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException ;


    public boolean saveOrders(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;


    }
