package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.SuperDAO;
import com.example.layeredarchitecture.model.ViewOrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO  extends SuperDAO {
    ArrayList<ViewOrderDetailDTO> addTableAllCustomrOrderDetails(String id) throws ClassNotFoundException, SQLException;

}
