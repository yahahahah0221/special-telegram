package com.jjj.service.admin;

import com.jjj.dao.AdminNotice;
import com.jjj.pojo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminNoticeServiceImpl implements AdminNoticeService{
    @Autowired
    AdminNotice adminNotice;
    public List<Notice> selectAll() {
        return adminNotice.selectAll();
    }

    public void deleteNotice(int id) {
        adminNotice.deleteNotice(id);
    }

    public void updateNotice(Notice notice) {
        adminNotice.updateNotice(notice);
    }

    public Notice selectById(int id) {
        return adminNotice.seleteById(id);
    }

    public void addNotice(Notice notice) {
        adminNotice.addNotice(notice);
    }
}
