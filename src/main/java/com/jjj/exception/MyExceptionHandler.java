package com.jjj.exception;

import com.jjj.pojo.Busertable;
import com.jjj.pojo.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MyExceptionHandler implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        Map<String,Object> model=new HashMap<String, Object>();
        model.put("ex",o);
        if(e instanceof AdminLoginNoException){
            httpServletRequest.setAttribute("auser",new User());
            httpServletRequest.setAttribute("msg","没有登录，请登录");
            return new ModelAndView("/admin/login",model);
        }
        else if(e instanceof UserLoginNoException){
            httpServletRequest.setAttribute("buser",new Busertable());
            httpServletRequest.setAttribute("msg","没有登录，请登录");
            return new ModelAndView("/before/login",model);
        }
        else {
            return new ModelAndView("/error/error",model);
        }
    }
//    @ExceptionHandler({
//            AdminLoginNoException.class
//    })
//    public ModelAndView AdminNoLogin(HttpServletRequest request,Exception e){
//        request.setAttribute("msg",e.getMessage());
//        ModelAndView model=new ModelAndView();
//        model.setViewName("/admin/login");
//        return model;
//    }
//    @ExceptionHandler({
//            UserLoginNoException.class
//    })
//    public ModelAndView UserNoLogin(HttpServletRequest request,ModelAndView model,Exception e){
//        request.setAttribute("msg",e.getMessage());
//        return new ModelAndView("/before/login");
//    }
}
