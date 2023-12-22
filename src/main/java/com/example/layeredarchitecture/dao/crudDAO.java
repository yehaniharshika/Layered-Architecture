package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface crudDAO<T> extends SuperDAO {
    boolean save(T dto) throws SQLException, ClassNotFoundException;

    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    boolean update(T dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    boolean exit(String id) throws SQLException, ClassNotFoundException;

    String generateNewId(String id) throws SQLException, ClassNotFoundException;

    T search(String id) throws SQLException, ClassNotFoundException;
}
