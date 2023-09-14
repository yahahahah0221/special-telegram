package com.jjj.service.admin;

import com.jjj.pojo.Goods;
import org.springframework.ui.Model;

import java.util.List;

public interface AdminGoodsService {
    List<Goods> selectGoods();
    int totalGoods();
    List<Goods> selectGoodsBuPage(int startIndex,int pageSize);
    Goods selectAGoods(int id);
    void insertGood(Goods goods);
    String deleteAGodds(int id);
    String deleteGodds(Integer ids[]);
    void updateGoods(Goods goods);
}
