package com.example.layeredarchitecture.Bo.custom.Impl;

import com.example.layeredarchitecture.Bo.CustomerBo;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.Impl.CustomerDAOImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.List;

public class CustomerBoImpl implements CustomerBo {
    CustomerDAO customerDAO = new CustomerDAOImpl(); //this is property Injection

    @Override
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(dto);
    }

    @Override
    public List<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
         return  customerDAO.getAll();
    }

    @Override
    public boolean exitCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exit(id);
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(dto);
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }

    @Override
    public String generateNextCustomerId(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.generateNewId(id);
    }
}
