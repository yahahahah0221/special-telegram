package com.jjj.service.admin;

import com.jjj.pojo.Admin;

public interface AdminService {
    public Admin selectByName(String name);
    public boolean AdminLogin(String name,String pwd);
}
