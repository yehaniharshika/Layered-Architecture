package com.example.layeredarchitecture.dao.custom.Impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ViewOrderDetailDTO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    public ArrayList<ViewOrderDetailDTO> addTableAllCustomrOrderDetails(String id) throws ClassNotFoundException, SQLException {


        ArrayList<ViewOrderDetailDTO> getAllCustomerOrderDetails = new ArrayList<>();

        ResultSet rst = SQLUtil.execute("SELECT c.id,c.name,o.oid,o.date,od.itemCode,od.qty,od.unitPrice FROM Customer c JOIN Orders o ON c.id=o.customerID JOIN OrderDetails od ON o.oid = od.oid where c.id=?",id);


        //Connection connection = DBConnection.getDbConnection().getConnection();
        //PreparedStatement pstm = connection.prepareStatement("SELECT c.id,c.name,o.oid,o.date,od.itemCode,od.qty,od.unitPrice FROM Customer c JOIN Orders o ON c.id=o.customerID JOIN OrderDetails od ON o.oid = od.oid where c.id=?;");

        //pstm.setString(1, id);
        //ResultSet rst = pstm.executeQuery();

            while (rst.next()) {
                ViewOrderDetailDTO viewOrderDetailDTO = new ViewOrderDetailDTO(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getString(5),
                        rst.getString(6),
                        rst.getString(7)
                );
                getAllCustomerOrderDetails.add(viewOrderDetailDTO);
            }

        return getAllCustomerOrderDetails;
    }


}
