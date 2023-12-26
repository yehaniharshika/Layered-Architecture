package lk.ijse.layeredarchitecture.dao;

import lk.ijse.layeredarchitecture.dao.custom.Impl.*;
import lk.ijse.layeredarchitecture.dao.custom.Impl.*;

public class DAOFactory {
    private  static DAOFactory daoFactory;
    //meka eference eka haraha thama call karagnne


    private  DAOFactory(){

    }

    public static DAOFactory getDaoFactory(){
        return daoFactory == null ? daoFactory= new DAOFactory() : daoFactory;

    }

    public  enum DAOTypes{
        CUSTOMER,ITEM,ORDER,ORDER_DETAILS,QUERY
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER:
                return new CustomerDAOImpl();

            case ITEM:
                return  new ItemDAOImpl();

            case ORDER:
                return  new OrderDAOImpl();

            case ORDER_DETAILS:
                return  new OrderDetailDAOImpl();

            case QUERY:
                return  new QueryDAOImpl();
            default:
                return null;
        }
    }
}
