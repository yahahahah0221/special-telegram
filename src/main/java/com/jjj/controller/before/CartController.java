package com.jjj.controller.before;

import com.jjj.pojo.Busertable;
import com.jjj.service.before.BeforeCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseBeforeController{
    @Autowired
    BeforeCartService service;
    @RequestMapping("/selectCart")
    public String selectCart(HttpSession session, Model model){
        Busertable user = (Busertable) session.getAttribute("bruser");
        int id = user.getId();
        List<Map<String ,Object>> list;
        list=service.selectCart(id);
        double num=0;
        for(Map<String,Object> map:list) {

            num+=(Double) map.get("smallsum");
        }
        model.addAttribute("cartlist",list);
        model.addAttribute("total",num);
        return "before/cart";
    }
    @RequestMapping("/deleteAgoods")
    public String deleteAgoods(int id){
        service.deleteCartById(id);
        return "forward:selectCart";
    }
    @RequestMapping("/clear")
    public String clear(HttpSession session){
        Busertable bruser =(Busertable) session.getAttribute("bruser");
        int id=bruser.getId();
        service.deleteAll(id);
        return "forward:selectCart";
    }
    @RequestMapping("putCart")
    public String putCart(int id,int shoppingnum,HttpSession session,Model model){
//        System.out.println(id+shoppingnum);
        String str=service.putCart(id,shoppingnum,session);
        model.addAttribute("msg",str);
        return "forward:/goodsDetail?id="+id;
    }
    @RequestMapping("/focus")
    public String focus(int id,HttpSession session,Model m){
        System.out.println(id);
        String str=service.putFocut(id,session);
        m.addAttribute("msg",str);
        return "forward:/goodsDetail?id="+id;
    }
    @RequestMapping("/orderConfirm")
    public String orderConfirm(HttpSession session,Model model){
        Busertable user = (Busertable) session.getAttribute("bruser");
        int id = user.getId();
        List<Map<String ,Object>> list;
        list=service.selectCart(id);
        double num=0;
        for(Map<String,Object> map:list) {

            num+=(Double) map.get("smallsum");
        }
        model.addAttribute("cartlist",list);
        model.addAttribute("total",num);
        return "before/orderconfirm";
    }
}
