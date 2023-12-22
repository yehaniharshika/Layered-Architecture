package com.example.layeredarchitecture.Bo.custom.Impl;

import com.example.layeredarchitecture.Bo.ItemBo;
import com.example.layeredarchitecture.dao.custom.Impl.ItemDAOImpl;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBo {
    ItemDAO itemDAO = new ItemDAOImpl();

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
       return itemDAO.getAll();
    }

    @Override
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return  itemDAO.save(dto);
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(dto);
    }

    @Override
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(code);
    }

    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exit(code);
    }

    @Override
    public String generateNextItemCode(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewId(code);
    }

    @Override
    public ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException {
        return itemDAO.search(newItemCode);
    }
}
