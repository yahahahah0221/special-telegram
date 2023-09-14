package com.jjj.service.before;

import com.jjj.pojo.Busertable;
import com.jjj.pojo.Goods;
import com.jjj.pojo.OrderBaseTable;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface BeforeUserService {
    boolean selectByEmail(Busertable buser,HttpSession session);
    void insertBuser(Busertable buser);
    boolean selectByEmailIs(Busertable buser,HttpSession session);
    List<OrderBaseTable> selectOrderByEmail(String email);
    List<Goods> selectFocustableGoodsByEmail(String email);
    List<Map<String, Object>> selectOrderDetail(Integer id);
}
