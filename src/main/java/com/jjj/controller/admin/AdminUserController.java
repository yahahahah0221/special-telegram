package com.jjj.controller.admin;

import com.jjj.pojo.Busertable;
import com.jjj.service.admin.AdminUserService;
import com.jjj.service.admin.AdminUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/adminUser")
public class AdminUserController extends BaseController {
    @Autowired
    AdminUserServiceImpl adminUserService;
    @RequestMapping("userInfo")
    public String userInfo(Model model){
        List<Busertable> busertables =adminUserService.selectInfo();
        model.addAttribute("userList",busertables);
        return "admin/userManger";
    }

    @RequestMapping("/deleteuserManager")
    public String deleteuserManager(int id,Model model){
        adminUserService.deleteUser(id);
        model.addAttribute("msg","删除成功");
        return "forward:userInfo";
    }
}
