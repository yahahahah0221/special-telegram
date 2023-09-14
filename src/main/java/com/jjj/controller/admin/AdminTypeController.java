package com.jjj.controller.admin;

import com.jjj.service.admin.AdminTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/adminType")
public class AdminTypeController extends BaseController{
    @Autowired
    private AdminTypeService adminTypeService;

    @RequestMapping("/toAddType")
    public String toAddType(Model model){
        model.addAttribute("allTypes",adminTypeService.selectAll());
        return "admin/addType";
    }

    @RequestMapping("/addType")
    public String addType(String typename, Model model, HttpSession session){
        adminTypeService.addGoodsType(typename);
        session.setAttribute("goodType",adminTypeService.selectAll());
        return "forward:adminType/toAddType";
    }

    @RequestMapping("/toDeleteType")
    public String toDeleteType(Model model){
        model.addAttribute("allTypes",adminTypeService.selectAll());
        return "admin/deleteType";
    }
    @RequestMapping("/deleteType")
    public String deleteType(int id,Model model){
        if(adminTypeService.selectGoodsByType(id).size()==0){
            adminTypeService.deleteGoodsType(id);
            model.addAttribute("msg","删除成功");
        }
        else
            model.addAttribute("msg","类型有链接不允许删除");
            return "forward:/adminType/toDeleteType";
    }
}
