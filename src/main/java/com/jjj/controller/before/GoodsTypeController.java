package com.jjj.controller.before;

import com.jjj.dao.BeforeIndexDao;
import com.jjj.pojo.Goods;
import com.jjj.service.before.BeforeSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class GoodsTypeController {
    @Autowired
    private BeforeSearchService beforeSearchService;

}
