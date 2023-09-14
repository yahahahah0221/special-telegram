package com.jjj.service.before;

import com.jjj.dao.CartDao;
import com.jjj.pojo.Busertable;
import com.jjj.pojo.Carttable;
import com.jjj.pojo.Focustable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
@Service
public class BeforeCartServiceImpl implements BeforeCartService{
    @Autowired
    CartDao cartDao;
    public List<Map<String, Object>> selectCart(int id) {
        return cartDao.selectCart(id);
    }

    public void deleteCartById(int id) {
        cartDao.deleteCartById(id);
    }

    public void deleteAll(int id) {
        cartDao.deleteAll(id);
    }

    public String putCart(int id, int shoppnum, HttpSession session) {
        if(shoppnum<=0)
            return "数量不能小于1";
        Carttable carttable=new Carttable();
        Busertable busertable=(Busertable)session.getAttribute("bruser");
        int bid=busertable.getId();
        carttable.setBusertable_id(bid);
        carttable.setGoodstable_id(id);
        carttable.setShoopingnum(shoppnum);
        cartDao.addCart(carttable);
        return "添加成功";
    }

    public String putFocut(int id, HttpSession session) {
        Busertable busertable= (Busertable) session.getAttribute("bruser");
        int bid=busertable.getId();
        List<Focustable> focustables = cartDao.selectFocusByBid(bid);
        for(Focustable focustable:focustables){
            if(focustable.getGoodstable_id()==id)
                return "添加失败，已经喜欢上了呢";
        }
        Focustable focustable=new Focustable();
        focustable.setBusertable_id(bid);
        focustable.setGoodstable_id(id);
        focustable.setFocustime(new Timestamp(System.currentTimeMillis()));
        cartDao.addFocus(focustable);
        return "喜欢上了";
    }
}
