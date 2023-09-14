package com.jjj.service.before;

import com.jjj.dao.BeforeUserDao;
import com.jjj.pojo.Busertable;
import com.jjj.pojo.Goods;
import com.jjj.pojo.OrderBaseTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class BeforeUserServiceImpl implements BeforeUserService{
    @Autowired
    BeforeUserDao dao;
    public boolean selectByEmail(Busertable busertable, HttpSession session) {
        Busertable buser=dao.selectByEmail(busertable.getBemail());
        if(buser==null)
            return false;
        else if( buser.getBpwd().equals(busertable.getBpwd()))
        {
            session.setAttribute("bruser",buser);
            return true;
        }
        else return false;
    }

    public void insertBuser(Busertable buser) {
        dao.insertBuser(buser);
    }

    public boolean selectByEmailIs(Busertable busertable,HttpSession session){
       Busertable buser= dao.selectByEmail(busertable.getBemail());
        if(buser==null)
        {
            dao.insertBuser(busertable);
            Busertable buser1=dao.selectByEmail(busertable.getBemail());
            session.setAttribute("bruser",buser1);
            return true;
        }
        else return false;
    }

    public List<OrderBaseTable> selectOrderByEmail(String email) {
        return dao.selectOrderByEmail(email);
    }

    public List<Goods> selectFocustableGoodsByEmail(String email) {
        return dao.selectGoodsTableByEmail(email);
    }

    public List<Map<String, Object>> selectOrderDetail(Integer id) {
        List<Map<String,Object>> orderDetail =dao.selectOrderDetailByOrderBaseid(id);
        return orderDetail;
    }

}
