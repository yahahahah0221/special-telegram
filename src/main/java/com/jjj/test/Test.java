package com.jjj.test;

import com.jjj.dao.AdminGoodsDao;
import com.jjj.dao.OrderDao;
import com.jjj.pojo.Admin;
import com.jjj.pojo.Goods;
import com.jjj.pojo.GoodsType;
import com.jjj.service.admin.AdminNoticeService;
import com.jjj.service.admin.AdminOrderService;
import com.jjj.service.admin.AdminServiceImpl;
import com.jjj.service.admin.AdminTypeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext=new FileSystemXmlApplicationContext(" D:\\Project1\\ssm\\src\\main\\webapp\\WEB-INF\\springmvc-servlet.xml");
        AdminNoticeService adminOrderService=(AdminNoticeService) applicationContext.getBean("adminNoticeService");
        System.out.println(adminOrderService.selectAll());
    }
}
