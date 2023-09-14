package com.jjj.controller.before;

import com.alibaba.fastjson.JSON;
import com.jjj.pojo.Busertable;
import com.jjj.pojo.Goods;
import com.jjj.pojo.OrderBaseTable;
import com.jjj.pojo.OrderDetail;
import com.jjj.service.before.BeforeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    BeforeUserService beforeUserService;
    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        model.addAttribute("buser",new Busertable());
        return "before/login";
    }
    @RequestMapping("/login")
    public String login(Model model, Busertable buser, String code, HttpSession session){
        if(!code.equals(session.getAttribute("checkCode"))){
            System.out.println(session.getAttribute("checkCode"));
            model.addAttribute("msg","验证码错误");
            return "forward:toLogin";
        }
        else if (beforeUserService.selectByEmail(buser,session)){
            return "forward:/before";
        }
        else {
            model.addAttribute("msg","账号或密码错误");
            return "forward:toLogin";
        }
    }
    @RequestMapping("toRegister")
    public String toRegister(Model model){
        model.addAttribute("buser",new Busertable());
        return "before/register";
    }
    @RequestMapping("register")
    public String register(Model model,Busertable buser,String code,HttpSession session){
        if(!code.equals(session.getAttribute("checkCode"))){
            System.out.println(session.getAttribute("checkCode"));
            model.addAttribute("msg","验证码错误");
            return "forward:toRegister";
        }
        if(beforeUserService.selectByEmailIs(buser,session)){
            return "forward:/before";
        }
        else{
            model.addAttribute("msg","Email已被注册");
            return "forward:toRegister";
        }
    }
    @RequestMapping("userCenter")
    public String userCenter(Model model,HttpSession session){
        Busertable busertable=(Busertable) session.getAttribute("bruser");
        String em=busertable.getBemail();
        List<OrderBaseTable> list= beforeUserService.selectOrderByEmail(em);
        model.addAttribute("myOrder",list);

        List<Goods> list1= beforeUserService.selectFocustableGoodsByEmail(em);
        model.addAttribute("myFocus",list1);
        return "before/userCenter";
    }
    @RequestMapping("orderDetail")
    public String orderDetail(Integer ordersn,Integer id,Model model){
        if(ordersn!=null) {
            List<Map<String,Object>> orderDetail = beforeUserService.selectOrderDetail(ordersn);
//            System.out.println(orderDetail.toString() + orderDetail.getGname());
            model.addAttribute("myOrderDetail", orderDetail);
            return "before/userOrderDetail";
        }
        else return "userCenter";
    }
    @RequestMapping("exit")
    public String exit(HttpSession session){
        session.invalidate();
        return "before/index";
    }
}
