package com.jjj.dao;

import com.jjj.pojo.*;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface BeforeUserDao {
     public Busertable selectByEmail(String email);
     public void insertBuser(Busertable buser);
     List<OrderBaseTable> selectOrderByEmail(String email);
     List<Goods> selectGoodsTableByEmail(String email);
     @MapKey("id")
     List<Map<String ,Object>> selectOrderDetailByOrderBaseid(Integer id);
     Goods selectGoodsById(Integer id);
}
