package com.jjj.service.before;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
public interface OrderService {
    int orderSubmit(double sum, HttpSession session);
    void pay(int id);
}
