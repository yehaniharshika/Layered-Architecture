package com.example.layeredarchitecture.model;

public class ViewOrderDetailDTO {
    private  String id;
    private  String name;
    private String oid;
    private String date;
    private String itemcode;
    //private String description;
    private String qty;
    private String unitprice;

    public ViewOrderDetailDTO(){

    }

    public ViewOrderDetailDTO(String id, String name, String oid, String date, String itemCode, String qty, String unitprice){
        this.id = id;
        this.name =  name;
        this.oid = oid;
        this.date = date;
        this.itemcode = itemCode;
        this.qty = qty;
        this.unitprice = unitprice;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

   /* public void setDescription(String description) {
        this.description = description;
    }*/

    public void setQty(String qty) {
        this.qty = qty;
    }

    public void setUnitprice(String unitprice) {
        this.unitprice = unitprice;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOid() {
        return oid;
    }

   /* public String getDescription() {
        return description;
    }*/

    public String getDate() {
        return date;
    }

   public String getItemcode() {
        return itemcode;
    }

    public String getQty() {
        return qty;
    }

    public String getUnitprice() {
        return unitprice;
    }

    @Override
    public String toString() {
        return "ViewOrderDetailDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", oid='" + oid + '\'' +
                ", date='" + date + '\'' +
                ", itemcode='" + itemcode + '\'' +
                ", qty='" + qty + '\'' +
                ", unitprice='" + unitprice + '\'' +
                '}';
    }
}
