package com.jjj.service.admin;

import com.jjj.controller.admin.BaseController;
import com.jjj.pojo.Busertable;

import java.util.List;

public interface AdminUserService {
    List<Busertable> selectInfo();
    void deleteUser(int id);
}
