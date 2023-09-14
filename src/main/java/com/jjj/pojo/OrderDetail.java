package com.jjj.pojo;

public class OrderDetail {
    Integer id;
    Integer orderbasetable_id;
    Integer goodstable_id;
    Integer shoppingnum;
    OrderBaseTable orderBaseTable;
    Goods goods=new Goods();
    public void setGname(String name){
        goods.setGname(name);
    }
    public String getGname(){
        return goods.getGname();
    }
    public void setGpicture(String v){
        goods.setGpicture(v);
    }
    public String getGpicture(){
        return goods.getGpicture();
    }
    public void setGrprice(double z){
        goods.setGrprice(z);
    }
    public double getGrprice(){
        return goods.getGrprice();
    }

    public OrderBaseTable getOrderBaseTable() {
        return orderBaseTable;
    }

    public void setOrderBaseTable(OrderBaseTable orderBaseTable) {
        this.orderBaseTable = orderBaseTable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderbasetable_id() {
        return orderbasetable_id;
    }

    public void setOrderbasetable_id(Integer orderbasetable_id) {
        this.orderbasetable_id = orderbasetable_id;
    }

    public Integer getGoodstable_id() {
        return goodstable_id;
    }

    public void setGoodstable_id(Integer goodstable_id) {
        this.goodstable_id = goodstable_id;
    }

    public Integer getShoppingnum() {
        return shoppingnum;
    }

    public void setShoppingnum(Integer shoppingnum) {
        this.shoppingnum = shoppingnum;
    }
}
