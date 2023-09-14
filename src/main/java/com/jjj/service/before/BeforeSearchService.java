package com.jjj.service.before;

import com.jjj.pojo.Goods;

import java.util.List;

public interface BeforeSearchService {
    List<Goods> selectGoodsByGoodsTypeId(int id);
    List<Goods> selectGoddsByMyKey(String mykey);
    Goods GoodsDetailByid(int id);
}
