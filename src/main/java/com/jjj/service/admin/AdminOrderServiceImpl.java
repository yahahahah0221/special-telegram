package com.jjj.service.admin;

import com.jjj.dao.OrderDao;
import com.jjj.pojo.OrderBaseTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminOrderServiceImpl implements AdminOrderService{

    @Autowired
    OrderDao orderDao;
    public void deleteOrderDetail(int id) {
        orderDao.deleteOrderDetail(id);
    }

    public void deleteOrderBase(int id) {
        orderDao.deleteOrderBase(id);
    }
    public List<OrderBaseTable> selectInfo(){
        return orderDao.selectInfo();
    }
}
