package com.jjj.service.before;

import com.jjj.pojo.Goods;
import com.jjj.pojo.GoodsType;
import com.jjj.pojo.Notice;

import java.util.List;

public interface BeforeIndexService {
    public List<GoodsType> selectGoodsType();
    List<Notice> slectAllNotice();
    Notice selectNoticeById(int id);
    List<Goods> selectXiaoLiang();
    List<Goods> selectXihuan();
    List<Goods> selectNew();
}
