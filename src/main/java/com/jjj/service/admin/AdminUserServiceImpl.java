package com.jjj.service.admin;

import com.jjj.controller.admin.BaseController;
import com.jjj.dao.AdminUserDao;
import com.jjj.pojo.Busertable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminUserServiceImpl implements AdminUserService{
    @Autowired
    AdminUserDao adminUser;
    public List<Busertable> selectInfo() {
        return adminUser.selectInfo();
    }

    public void deleteUser(int id) {
        adminUser.deleteUser(id);
    }
}
