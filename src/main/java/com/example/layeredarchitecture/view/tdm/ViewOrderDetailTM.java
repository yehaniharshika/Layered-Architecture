package com.example.layeredarchitecture.view.tdm;

import java.math.BigDecimal;

public class ViewOrderDetailTM {

    private  String id;
    private  String name;
    private String oid;
    private String date;
    private String itemcode;
    //private String description;
    private int qty;
    private BigDecimal unitprice;

    public ViewOrderDetailTM(String id, String name, String oid, String date, String itemcode, String qty, String unitprice){

    }

    public ViewOrderDetailTM(String id,String name,String oid,String date,String itemCode,int qty,BigDecimal unitprice){
        this.id = id;
        this.name =  name;
        this.oid = oid;
        this.date = date;
        this.itemcode = itemCode;
        //this.description= description;
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

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setUnitprice(BigDecimal unitprice) {
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

    /*public String getDescription() {
        return description;
    }*/

    public String getDate() {
        return date;
    }

    public String getItemcode() {
        return itemcode;
    }

    public int getQty() {
        return qty;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    @Override
    public String toString() {
        return "ViewOrderDetailTM{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", oid='" + oid + '\'' +
                ", date='" + date + '\'' +
                ", itemcode='" + itemcode + '\'' +
                ", qty=" + qty +
                ", unitprice=" + unitprice +
                '}';
    }
}
