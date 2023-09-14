package com.jjj.dao;

import com.jjj.pojo.Notice;

import java.util.List;

public interface AdminNotice {
    List<Notice> selectAll();
    void addNotice(Notice notice);
    void deleteNotice(int id);
    Notice seleteById(int id);
    void updateNotice(Notice notice);
}
