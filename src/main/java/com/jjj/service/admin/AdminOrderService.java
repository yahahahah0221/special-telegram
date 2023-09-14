package com.jjj.service.admin;

import com.jjj.pojo.OrderBaseTable;

import java.util.List;

public interface AdminOrderService {
    void deleteOrderDetail(int id);
    void deleteOrderBase(int id);
    List<OrderBaseTable> selectInfo();
}
