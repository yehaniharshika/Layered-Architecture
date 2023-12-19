package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;
import com.example.layeredarchitecture.view.tdm.OrderDetailTM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl  implements ItemDAO{

    private ItemDAOImpl itemDAO;

    @Override
    public  ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Item");

        ArrayList<ItemDTO> getAllItem = new ArrayList<>();

        while (rst.next()){
            getAllItem.add(new ItemDTO(
                  rst.getString("code"),
                  rst.getString("description"),
                  rst.getBigDecimal("unitPrice"),
                  rst.getInt("qtyOnHand")
            ));
        }
        return getAllItem;
    }

    @Override
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
        pstm.setString(1, dto.getCode());
        pstm.setString(2, dto.getDescription());
        pstm.setBigDecimal(3, dto.getUnitPrice());
        pstm.setInt(4, dto.getQtyOnHand());

        boolean isSaved = pstm.executeUpdate() > 0;
        return isSaved;
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
        pstm.setString(1, dto.getDescription());
        pstm.setBigDecimal(2, dto.getUnitPrice());
        pstm.setInt(3, dto.getQtyOnHand());
        pstm.setString(4, dto.getCode());

        boolean isUpdated =pstm.executeUpdate() > 0;

        return isUpdated;
    }

    /*public boolean updateItems(List<OrderDetailTM> orderDetailTMList) throws SQLException, ClassNotFoundException {
        for (OrderDetailTM tm : orderDetailTMList){
            if(!updateQty(tm.getCode(),tm.getQty())){
                return false;
            }
        }
        return true;
    }

    private boolean updateQty(String code, int qty) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        String sql ="UPDATE Item SET qtyOnHand = qtyOnHand - ? WHERE code = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setInt(1,qty);
        pstm.setString(2,code);

        return  pstm.executeUpdate() > 0;
    }*/

    @Override
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
        pstm.setString(1, code);
        boolean isDeleted = pstm.executeUpdate() > 0;
        return isDeleted;
    }

    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
        pstm.setString(1, code);
        return pstm.executeQuery().next();
    }

    //search Item
    @Override
    public ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
        pstm.setString(1, newItemCode);
        ResultSet rst = pstm.executeQuery();
        ItemDTO item = null;
        if (rst.next()){
            item= new ItemDTO(newItemCode + "",
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand"));

        }
        return item;
    }


    @Override
    public String generateNextItemCode(String code) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    public  boolean updateItemQuantity(ItemDTO item, OrderDetailDTO detail) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());
        boolean isUpdated = itemDAO.updateItem(item);
        if (!isUpdated){
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

        return isUpdated;
    }


}
