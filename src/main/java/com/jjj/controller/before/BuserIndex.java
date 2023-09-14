package com.jjj.controller.before;

import com.alibaba.fastjson.JSON;
import com.jjj.pojo.Goods;
import com.jjj.pojo.GoodsType;
import com.jjj.pojo.Notice;
import com.jjj.service.before.BeforeIndexService;
import com.jjj.service.before.BeforeIndexServiceImpl;
import com.jjj.service.before.BeforeSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class BuserIndex {
    @Autowired
    BeforeIndexService beforeIndexService;
    @Autowired
    BeforeSearchService beforeSearchService;
    @RequestMapping("/before")
    public String userIndex(Model model,Integer id){
        //查询商品类型
        List<GoodsType> list = beforeIndexService.selectGoodsType();
        //查询所有告示
        List<Notice> listnotic=beforeIndexService.slectAllNotice();
        //查询人气榜通过被关注的次数、
        List<Goods> listGuan=beforeIndexService.selectXihuan();
        //查询销量榜
        List<Goods> listRen=beforeIndexService.selectXiaoLiang();
        //最新商品
        List<Goods> listGoods=beforeIndexService.selectNew();
        model.addAttribute("lastedlist",listGoods);
        model.addAttribute("salelist",listRen);
        model.addAttribute("focuslist",listGuan);
        model.addAttribute("noticelist",listnotic);
        model.addAttribute("goodsType",list);
        if(id==null||id==0)
        return "before/index";
        else
        {
            List<Goods> goods = beforeSearchService.selectGoodsByGoodsTypeId(id);
            model.addAttribute("searchlist",goods);
            return "before/searchResult";
        }
    }
    @RequestMapping("selectANotice")
    public  String selectANotice (Model model, int id, HttpServletResponse response){
        Notice notice=beforeIndexService.selectNoticeById(id);
        model.addAttribute("notice",notice);
        return "admin/noticeDetail";
    }
}
