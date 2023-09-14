package com.jjj.service.admin;

import com.jjj.pojo.Notice;

import java.util.List;

public interface AdminNoticeService {
    List<Notice> selectAll();
    void deleteNotice(int id);
    void updateNotice(Notice notice);
    Notice selectById(int id);
    void addNotice(Notice notice);
}
