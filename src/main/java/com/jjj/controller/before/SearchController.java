package com.jjj.controller.before;

import com.jjj.pojo.Goods;
import com.jjj.service.before.BeforeSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    BeforeSearchService beforeSearchService;
    @RequestMapping("/search")
    public String Search(String mykey, Model model){
        List<Goods> goodsList=beforeSearchService.selectGoddsByMyKey(mykey);
        model.addAttribute("searchlist",goodsList);
    return "before/searchResult";
    }
    @RequestMapping("/goodsDetail")
    public String  GoodsDetail(int id,Model model){
        Goods goods=beforeSearchService.GoodsDetailByid(id);
        model.addAttribute("goods",goods);
        return "before/goodsdetail";
    }
}
