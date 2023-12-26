package lk.ijse.layeredarchitecture.dao.custom;

import lk.ijse.layeredarchitecture.dao.SuperDAO;
import lk.ijse.layeredarchitecture.dto.ViewOrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO  extends SuperDAO {
    ArrayList<ViewOrderDetailDTO> addTableAllCustomrOrderDetails(String id) throws ClassNotFoundException, SQLException;

}
