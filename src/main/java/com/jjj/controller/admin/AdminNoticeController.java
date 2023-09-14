package com.jjj.controller.admin;

import com.jjj.pojo.Notice;
import com.jjj.service.admin.AdminNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("adminNotice")
public class AdminNoticeController extends BaseController {
    @Autowired
    AdminNoticeService adminNoticeService;
    @RequestMapping("deleteNoticeSelect")
    public String deleteNoticeSelect(Model model){
        List<Notice> list=adminNoticeService.selectAll();
        model.addAttribute("allNotices",list);
        return "admin/deleteNoticeSelect";
    }
    @RequestMapping("toAddNotice")
    public String toAddNotice(Model model){
        model.addAttribute("notice",new Notice());
        return "admin/addNotice";
    }
    @RequestMapping("/addNotice")
    public String addNotice(Model model,Notice notice){
        notice.setNtime(new Timestamp(System.currentTimeMillis()));
        adminNoticeService.addNotice(notice);
        return "forward:deleteNoticeSelect";
    }
    @RequestMapping("/deleteNotice")
    public String  deleteNotice(int id){
        adminNoticeService.deleteNotice(id);
        return "forward:deleteNoticeSelect";
    }
    @RequestMapping("selectANotice")
    public String selectANotice(int id,Model model){
        Notice notice=adminNoticeService.selectById(id);
        model.addAttribute("notice",notice);
        return "admin/noticeDetail";
    }
}
