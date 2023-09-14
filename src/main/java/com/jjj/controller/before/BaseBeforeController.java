package com.jjj.controller.before;

import com.jjj.exception.UserLoginNoException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BaseBeforeController {
    @ModelAttribute
    public void isLogin(HttpServletRequest request, HttpSession session) throws UserLoginNoException {
        if (session.getAttribute("bruser")==null){
            throw new UserLoginNoException("没有登陆");
        }
        else {
            System.out.println("hhh1");
        }
    }
}
