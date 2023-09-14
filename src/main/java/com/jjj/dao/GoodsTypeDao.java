package com.jjj.dao;

import com.jjj.pojo.Goods;
import com.jjj.pojo.GoodsType;

import java.util.List;

public interface GoodsTypeDao {
    List<GoodsType> selectAll();
    GoodsType selectByName(String name);
    void deleteGoodsType(int id);
    void addGoodsType(String name);
    List<Goods> selectGoodsByType(int id);
}
