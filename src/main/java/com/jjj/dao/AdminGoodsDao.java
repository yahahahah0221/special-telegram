package com.jjj.dao;

import com.jjj.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminGoodsDao {
    List<Goods> selectGoods();
    int totalGoods();
    List<Goods> selectGoodsByPage(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize);
    Goods selectAGoods(int id);
    void insertGoods(Goods goods);
    void deleteAGoods(int id);
    void deleteGoods(Integer ids[]);
    void updateGoods(Goods goods);
    List<Carttable>selectCartBGood(Integer[] ids);
    List<Focustable>selectFouce(Integer[] ids);
    List<OrderDetail>selectOrderDe(Integer[] ids);
    List<Carttable> selectACartBGood(int id);
    List<Focustable> selectAFouce(int id);
    List<OrderDetail> selectAOrderDe(int id);
}
