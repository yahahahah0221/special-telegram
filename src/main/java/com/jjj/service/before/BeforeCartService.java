package com.jjj.service.before;

import com.jjj.pojo.Carttable;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface BeforeCartService {
    List<Map<String,Object>> selectCart(int id);
    void deleteCartById(int id);
    void deleteAll(int id);
    String putCart(int id, int shoppnum, HttpSession session);
    String putFocut(int id,HttpSession session);
}
