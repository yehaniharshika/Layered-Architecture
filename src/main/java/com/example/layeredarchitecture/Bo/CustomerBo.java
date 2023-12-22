package com.example.layeredarchitecture.Bo;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBo {
    boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    List<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
    boolean exitCustomer(String id) throws SQLException, ClassNotFoundException;
    boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    String generateNextCustomerId(String id) throws SQLException, ClassNotFoundException;
}
