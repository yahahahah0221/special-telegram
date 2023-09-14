package com.jjj.dao;

import com.jjj.pojo.Carttable;
import com.jjj.pojo.Focustable;
import org.apache.ibatis.annotations.MapKey;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface CartDao {
    @MapKey("cartid")
    List<Map<String,Object>> selectCart(int id);
    void deleteCartById(int cartId);
    void deleteAll(int id);
    void addCart(Carttable carttable);
    void addFocus(Focustable focustable);
    List<Focustable> selectFocusByBid(int bid);
}
