package com.jjj.dao;

import com.jjj.pojo.Goods;
import com.jjj.pojo.OrderBaseTable;
import com.jjj.pojo.OrderDetail;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.util.List;

public interface OrderDao {
    void deleteOrderDetail(int  id);
    void deleteOrderBase(int id);
    List<OrderBaseTable> selectInfo();
    void addOrder(OrderBaseTable orderBaseTable);
    int selectLastid();
    void addOrderDetail(OrderDetail orderDetail);
    void updateGoodsNumByOrder(Goods goods);
    void updateOrderStatus(int id);
}
