package com.jjj.controller.admin;

import com.jjj.pojo.Admin;
import com.jjj.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;
    @RequestMapping("/adminLogin")
    public String adminLogin(String adminName, String adminPwd, Model model, HttpSession session)  {
        if(adminService.AdminLogin(adminName,adminPwd)){
            Admin admin=new Admin();
            admin.setAname(adminName);
            admin.setApwd(adminPwd);
            session.setAttribute("admin",admin);
            return "/admin/main";
        }
        else {
//            throw new AdminLoginNoException();
         model.addAttribute("msg","账号和密码错误");
         return "admin/login";
        }
    }
    @RequestMapping("/admin")
    public String toLogin(){
        return "admin/login";
    }
    @RequestMapping("/exit")
    public String exit(HttpSession session){
        session.invalidate();
        return "admin/login";
    }
}
