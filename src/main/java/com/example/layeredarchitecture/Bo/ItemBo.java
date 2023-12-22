package com.example.layeredarchitecture.Bo;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBo {
    ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException ;

    boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException ;

    boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException ;

    boolean deleteItem(String code) throws SQLException, ClassNotFoundException ;

    boolean existItem(String code) throws SQLException, ClassNotFoundException;

    String generateNextItemCode(String code) throws SQLException, ClassNotFoundException ;

    ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException;
}
