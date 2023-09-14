package com.jjj.service.before;

import com.jjj.dao.BeforeSearchDao;
import com.jjj.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BeforeSearchServiceImpl implements BeforeSearchService{
    @Autowired
    private BeforeSearchDao beforeSearchDao;

    public List<Goods> selectGoodsByGoodsTypeId(int id) {
        return beforeSearchDao.selectGoodsByGoodsTypeId(id);
    }

    public List<Goods> selectGoddsByMyKey(String mykey) {
        return beforeSearchDao.selectGoodsByMykey(mykey);
    }

    public Goods GoodsDetailByid(int id) {
        return beforeSearchDao.GoodsDetailById(id);
    }
}
