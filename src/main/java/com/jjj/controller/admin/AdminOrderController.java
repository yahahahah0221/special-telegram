package com.jjj.controller.admin;

import com.jjj.pojo.OrderBaseTable;
import com.jjj.service.admin.AdminOrderService;
import com.jjj.service.admin.AdminOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("adminOrder")
public class AdminOrderController extends BaseController{
    @Autowired
    AdminOrderServiceImpl adminOrderService;
    @RequestMapping("/orderInfo")
    public String orderInfo(Model model){
        //查询所有订单信息
        List<OrderBaseTable>list=adminOrderService.selectInfo();
        model.addAttribute("orderList",list);
        return "admin/orderManager";
    }
    @RequestMapping("deleteorderManager")
    public String deleteorderManager(int id){
        adminOrderService.deleteOrderDetail(id);
        adminOrderService.deleteOrderBase(id);
        return "forward:orderInfo";
    }
}
