package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.view.tdm.CustomerTM;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl {

    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAddress());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;

    }

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");


        ArrayList<CustomerDTO> getAllCustomer = new ArrayList<>();

        while (rst.next()){
            getAllCustomer.add(new CustomerDTO(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address")
            ));


            //mehemath puluwan.uda thiyena dema thama wela thiyenne
            /*CustomerDTO customerDTO = new CustomerDTO(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address"));
            getAllCustomer.add(customerDTO);*/

        }
        return getAllCustomer;

    }

    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAddress());
        pstm.setString(3, dto.getId());

        boolean isUpdated = pstm.executeUpdate() > 0 ;
        return isUpdated;
    }

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
        pstm.setString(1, id);
        boolean isDeleted =  pstm.executeUpdate() > 0;
        return isDeleted;
    }

}
