package com.jjj.dao;

import com.jjj.pojo.Busertable;

import java.util.List;

public interface AdminUserDao {
    List<Busertable> selectInfo();
    void deleteUser(int id);
}
