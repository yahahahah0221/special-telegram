package com.jjj.service.admin;

import com.jjj.dao.AdminDao;
import com.jjj.pojo.Goods;
import com.jjj.pojo.GoodsType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AdminTypeService {
       List<GoodsType> selectAll();
       GoodsType selectByName(String name);
       void deleteGoodsType(int id);
       void addGoodsType(String name);
       List<Goods> selectGoodsByType(int id);
}
