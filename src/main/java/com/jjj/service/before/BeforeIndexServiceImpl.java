package com.jjj.service.before;

import com.jjj.dao.BeforeIndexDao;
import com.jjj.pojo.Goods;
import com.jjj.pojo.GoodsType;
import com.jjj.pojo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BeforeIndexServiceImpl implements BeforeIndexService{
    @Autowired
    BeforeIndexDao beforeIndexDao;
    public List<GoodsType> selectGoodsType() {
        return beforeIndexDao.selectGoodsType();
    }

    public List<Notice> slectAllNotice() {
        return beforeIndexDao.selectAllNotice();
    }

    public Notice selectNoticeById(int id) {
        return beforeIndexDao.selectNoticeById(id);
    }

    public List<Goods> selectXiaoLiang() {
        return beforeIndexDao.selectXiaoShou();
    }

    public List<Goods> selectXihuan() {
        return beforeIndexDao.selectRenQi();
    }

    public List<Goods> selectNew() {
        return beforeIndexDao.selectNew();
    }

}
