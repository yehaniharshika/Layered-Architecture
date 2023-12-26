package lk.ijse.layeredarchitecture.dao.custom;

import lk.ijse.layeredarchitecture.dao.crudDAO;
import lk.ijse.layeredarchitecture.dto.OrderDetailDTO;
import lk.ijse.layeredarchitecture.entity.OrderDetail;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO  extends crudDAO<OrderDetail> {
      //boolean saveOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException;
}
