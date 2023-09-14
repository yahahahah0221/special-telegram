package com.jjj.dao;

import com.jjj.pojo.Goods;
import com.jjj.pojo.GoodsType;
import com.jjj.pojo.Notice;

import java.util.List;

public interface BeforeIndexDao {
    List<GoodsType> selectGoodsType();
    List<Notice> selectAllNotice();
    Notice selectNoticeById(int id);
    List<Goods> selectXiaoShou();
    List<Goods> selectRenQi();
    List<Goods> selectNew();
}
