package com.jjj.service.admin;

import com.jjj.dao.AdminGoodsDao;
import com.jjj.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class AdminGoodsServiceImpl implements AdminGoodsService {
    @Autowired
    AdminGoodsDao adminGoodsDao;

    public List<Goods> selectGoods() {
        return adminGoodsDao.selectGoods();
    }

    public int totalGoods() {
        return adminGoodsDao.totalGoods();
    }

    public List<Goods> selectGoodsBuPage(int startIndex, int pageSize) {
        return adminGoodsDao.selectGoodsByPage(startIndex,pageSize);
    }

    public Goods selectAGoods(int id) {
        return adminGoodsDao.selectAGoods(id);
    }

    public void insertGood(Goods goods) {
        adminGoodsDao.insertGoods(goods);
    }

    public String deleteAGodds(int id) {
        if(adminGoodsDao.selectAFouce(id).size()>0||
                adminGoodsDao.selectAOrderDe(id).size()>0||
                adminGoodsDao.selectACartBGood(id).size()>0){
            System.out.println("1111");
            return "商品有关联，不准许删除";

        }
        else {
            adminGoodsDao.deleteAGoods(id);
            return "删除成功";
        }
    }

    public String deleteGodds(Integer ids[]) {
        if(adminGoodsDao.selectFouce(ids).size()>0||
        adminGoodsDao.selectOrderDe(ids).size()>0||
        adminGoodsDao.selectCartBGood(ids).size()>0){
           return "商品有关联，不准许删除";
        }
        else {
            adminGoodsDao.deleteGoods(ids);
            return "删除成功";
        }

    }

    public void updateGoods(Goods goods) {
        adminGoodsDao.updateGoods(goods);
    }

}
