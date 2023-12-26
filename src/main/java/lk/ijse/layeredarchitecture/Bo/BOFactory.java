package lk.ijse.layeredarchitecture.Bo;

import lk.ijse.layeredarchitecture.Bo.custom.Impl.CustomerBoImpl;
import lk.ijse.layeredarchitecture.Bo.custom.Impl.ItemBoImpl;
import lk.ijse.layeredarchitecture.Bo.custom.Impl.PlaceOrderBoImpl;

public class BOFactory {
    private static BOFactory boFactory;

    BOFactory(){

    }

    public  static BOFactory getBoFactory(){
        return  boFactory == null ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER,ITEM,PLACE_ORDER
    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case CUSTOMER:
                return new CustomerBoImpl();

            case ITEM:
                return new ItemBoImpl();

            case PLACE_ORDER:
                return new PlaceOrderBoImpl();

            default:
                return null;
        }

    }
}
