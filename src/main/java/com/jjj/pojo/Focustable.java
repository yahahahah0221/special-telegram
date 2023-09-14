package com.jjj.pojo;

import java.sql.Timestamp;
import java.util.List;

public class Focustable {
    private Integer id;
    private Integer busertable_id;
    private Integer goodstable_id;
    private Timestamp focustime;
    private List<Busertable> busertable;
    private List<Goods> goods;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBusertable_id() {
        return busertable_id;
    }

    public void setBusertable_id(Integer busertable_id) {
        this.busertable_id = busertable_id;
    }

    public Integer getGoodstable_id() {
        return goodstable_id;
    }

    public void setGoodstable_id(Integer goodstable_id) {
        this.goodstable_id = goodstable_id;
    }

    public Timestamp getFocustime() {
        return focustime;
    }

    public void setFocustime(Timestamp focustime) {
        this.focustime = focustime;
    }

    public List<Busertable> getBusertable() {
        return busertable;
    }

    public void setBusertable(List<Busertable> busertable) {
        this.busertable = busertable;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }
}
