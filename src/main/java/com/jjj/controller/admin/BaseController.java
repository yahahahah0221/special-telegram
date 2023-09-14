package com.jjj.controller.admin;

import com.jjj.exception.AdminLoginNoException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BaseController {
    @ModelAttribute
    public void isLogin(HttpServletRequest request, HttpSession session)
        throws  AdminLoginNoException {
            if (session.getAttribute("admin")==null){
                throw new AdminLoginNoException("没有登录");
            }
        }

}
