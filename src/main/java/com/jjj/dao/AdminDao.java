package com.jjj.dao;

import com.jjj.pojo.Admin;
import com.jjj.pojo.GoodsType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminDao {
    public Admin selectByName(String name);

}
