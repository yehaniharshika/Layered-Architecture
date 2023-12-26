package lk.ijse.layeredarchitecture.Bo;

import lk.ijse.layeredarchitecture.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBo extends SuperBO{
    ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException ;

    ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;

    boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException ;

    boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException ;

    boolean deleteItem(String code) throws SQLException, ClassNotFoundException ;

    boolean existItem(String code) throws SQLException, ClassNotFoundException;

    String generateNextItemCode(String code) throws SQLException, ClassNotFoundException ;

    //ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException;
}
