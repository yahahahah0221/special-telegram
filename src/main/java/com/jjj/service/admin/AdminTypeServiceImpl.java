package com.jjj.service.admin;

import com.jjj.dao.GoodsTypeDao;
import com.jjj.pojo.Goods;
import com.jjj.pojo.GoodsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminTypeServiceImpl implements AdminTypeService{

    @Autowired
    GoodsTypeDao goodsTypeDao;
    public List<GoodsType> selectAll() {
        return goodsTypeDao.selectAll();
    }

    public GoodsType selectByName(String name) {
        return goodsTypeDao.selectByName(name);
    }

    public void deleteGoodsType(int id) {
    goodsTypeDao.deleteGoodsType(id);
    }

    public void addGoodsType(String name) {
        goodsTypeDao.addGoodsType(name);
    }

    public List<Goods> selectGoodsByType(int id) {
        return goodsTypeDao.selectGoodsByType(id);
    }
}
