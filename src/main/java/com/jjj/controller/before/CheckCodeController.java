package com.jjj.controller.before;

import com.jjj.test.CheckCodeUtil;
import com.mysql.cj.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class CheckCodeController {
    @RequestMapping("validateCode")
    public void validateCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
        OutputStream os=response.getOutputStream();
        String s= CheckCodeUtil.outputVerifyImage(100,50,os,4);
        HttpSession session=request.getSession();
        session.setAttribute("checkCode",s);
    }
}
