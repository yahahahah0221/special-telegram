package com.jjj.controller.before;

import com.jjj.pojo.Goods;
import com.jjj.service.before.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @RequestMapping("orderSubmit")
    public String orderSubmit(double amount, HttpSession session, Model model){
        int i=orderService.orderSubmit(amount,session);
        model.addAttribute("ordersn",i);
        return "before/orderdone";
    }
    @RequestMapping("pay")
    public String pay(int ordersn){
        orderService.pay(ordersn);
        return "before/paydone";
    }
}

