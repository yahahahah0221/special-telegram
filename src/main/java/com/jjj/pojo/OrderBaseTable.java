package com.jjj.pojo;

import java.sql.Timestamp;

public class OrderBaseTable {
    int id;
    int busertable_id;
    double amout;
    boolean status;
    Timestamp orderdate;
    Busertable busertable;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "OrderBaseTable{" +
                "id=" + id +
                ", busertable_id=" + busertable_id +
                ", amount=" + amout +
                ", status=" + status +
                ", orderdate=" + orderdate +
                ", busertable=" + busertable +
                '}';
    }

    public Busertable getBusertable() {
        return busertable;
    }

    public void setBusertable(Busertable busertable) {
        this.busertable = busertable;
    }



    public int getBusertable_id() {
        return busertable_id;
    }

    public void setBusertable_id(int busertable_id) {
        this.busertable_id = busertable_id;
    }

    public double getAmout() {
        return amout;
    }

    public void setAmout(double amount) {
        this.amout = amount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Timestamp getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Timestamp orderdate) {
        this.orderdate = orderdate;
    }
}
