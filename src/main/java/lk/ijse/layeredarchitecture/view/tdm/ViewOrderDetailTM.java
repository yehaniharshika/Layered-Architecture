package lk.ijse.layeredarchitecture.view.tdm;

import java.math.BigDecimal;

public class ViewOrderDetailTM {

    private  String id;
    private  String name;
    private String oid;
    private String date;
    private String itemCode;
    //private String description;
    private int qty;
    private BigDecimal unitPrice;

    public  ViewOrderDetailTM(){

    }

    public ViewOrderDetailTM(String id, String name, String oid, String date, String itemCode, int qty, BigDecimal unitPrice) {
        this.id = id;
        this.name = name;
        this.oid = oid;
        this.date = date;
        this.itemCode = itemCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "ViewOrderDetailTM{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", oid='" + oid + '\'' +
                ", date='" + date + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
