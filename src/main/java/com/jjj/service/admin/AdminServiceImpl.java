package com.jjj.service.admin;

import com.jjj.dao.AdminDao;
import com.jjj.pojo.Admin;
import com.jjj.service.admin.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    AdminDao adminDao;


    public AdminServiceImpl(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public Admin selectByName(String name) {
        return adminDao.selectByName(name);
    }

    public boolean AdminLogin(String name, String pwd) {
        Admin admin=adminDao.selectByName(name);
        if(admin==null)
            return false;
        else
        return admin.getApwd().equals(pwd);

    }
}
