package com.jjj.service.before;

import com.jjj.dao.CartDao;
import com.jjj.dao.OrderDao;
import com.jjj.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderDao orderDao;
    @Autowired
    CartDao cartDao;
    public int orderSubmit(double sum, HttpSession session) {
        OrderBaseTable orderBaseTable=new OrderBaseTable();
        orderBaseTable.setAmout(sum);
        orderBaseTable.setOrderdate(new Timestamp(System.currentTimeMillis()));
        orderBaseTable.setStatus(false);
        Busertable busertable= (Busertable) session.getAttribute("bruser");
        int bid=busertable.getId();
        orderBaseTable.setBusertable_id(bid);
        orderDao.addOrder(orderBaseTable);
        int i = orderDao.selectLastid();
        List<Map<String, Object>> maps = cartDao.selectCart(bid);
        for (Map<String,Object> maps1:maps){
            int num= (Integer) maps1.get("shoppingnum");
            int id=(Integer) maps1.get("id");
            OrderDetail orderDetail=new OrderDetail();
            orderDetail.setShoppingnum(num);
            orderDetail.setGoodstable_id(id);
            orderDetail.setOrderbasetable_id(i);
            orderDao.addOrderDetail(orderDetail);
            Goods goods=new Goods();
            goods.setId(id);
            goods.setGstore(num);
            orderDao.updateGoodsNumByOrder(goods);
            cartDao.deleteAll(bid);
        }
        return i;
    }

    public void pay(int id) {
        orderDao.updateOrderStatus(id);
    }
}
