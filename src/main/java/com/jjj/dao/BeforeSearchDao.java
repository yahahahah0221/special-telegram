package com.jjj.dao;

import com.jjj.pojo.Goods;

import java.util.List;

public interface BeforeSearchDao {
    List<Goods> selectGoodsByGoodsTypeId(int id);
    List<Goods> selectGoodsByMykey(String mykey);
    Goods GoodsDetailById(int id);
}
