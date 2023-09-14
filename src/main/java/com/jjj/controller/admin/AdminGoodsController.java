package com.jjj.controller.admin;

import com.jjj.pojo.Goods;
import com.jjj.pojo.GoodsType;
import com.jjj.service.admin.AdminGoodsServiceImpl;
import com.jjj.service.admin.AdminTypeServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.prefs.NodeChangeEvent;

@Controller
@RequestMapping("/adminGoods")
public class AdminGoodsController extends BaseController{
    @Autowired
    AdminGoodsServiceImpl adminGoodsService;
    @Autowired
    AdminTypeServiceImpl adminTypeService;

    @RequestMapping("/selectGoods")
    public String selectGoods(Model model,Integer pageCur,String act){
        int pageSize=10;
        List<Goods> list=adminGoodsService.selectGoods();
        int total= list.size();
        model.addAttribute("totalCount",total);
        int totalPage;
        if(total==0){
            totalPage=0;
        }
        else {
            totalPage=(int)Math.ceil((double) total/pageSize);
        }
        if (pageCur==null){
            pageCur=1;
        }

        //分页查询
        int startIndex=(pageCur-1)*pageSize;
        List<Goods> allGoods=adminGoodsService.selectGoodsBuPage(startIndex,pageSize);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("pageCur",pageCur);
        model.addAttribute("allGoods",allGoods);
        if(act==null)
            return "admin/selectGoods";
        if(act.equals("deleteSelect"))
            return "admin/deleteSelectGoods";
        if(act.equals("updateSelect"))
            return "admin/updateSelectGoods";
        return "admin/selectGoods";
    }
    @RequestMapping("/selectAGoods")
    public String selectAGoods(int id,Model model,String act){
    Goods good=adminGoodsService.selectAGoods(id);
    model.addAttribute("goods",good);
    if(act==null)
        return "admin/goodsDetail";
    if(act.equals("updateAgoods")) {
        List<GoodsType> list= adminTypeService.selectAll();
        model.addAttribute("goodsType",list);
        System.out.println(good);
        return "admin/updateAGoods";
    }
    else
        return "admin/goodsDetail";
    }
    @RequestMapping("/toAddGoods")
    public String toAddGoods(Model model){
        List<GoodsType> list= adminTypeService.selectAll();
        model.addAttribute("goodsType",list);
        Goods goods=new Goods();
        model.addAttribute("goods",goods);
        return "admin/addGoods";
    }
    @RequestMapping("/addGoods")
    public String addGoods(@ModelAttribute() Goods goods, Model model,String act) throws IOException {

        MultipartFile file = goods.getLogoImage();
        if(file!=null) {
            String fileName = file.getOriginalFilename();
            String filePath = "D:\\Project1\\ssm\\src\\main\\webapp\\images\\";
            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                goods.setGpicture(fileName);
                model.addAttribute("message", "上传成功");
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("message", "上传失败");
            }
        }
        if(act!=null && act.equals("update"))
            adminGoodsService.updateGoods(goods);
        else
            adminGoodsService.insertGood(goods);
        System.out.println(goods);
        return "forward:selectGoods";
    }

    @RequestMapping("/deleteAGoods")
    public String  deleteAGoods(int id,Model model){
        String s=adminGoodsService.deleteAGodds(id);
        model.addAttribute("msg",s);
        return "forward:selectGoods?act=deleteSelect";
    }
    @RequestMapping("/deleteGoods")
    public String deleteGoods(Integer ids[], Model model){
        String s=adminGoodsService.deleteGodds(ids);
        model.addAttribute("msg",s);
        return "forward:selectGoods?act=deleteSelect";
    }
}
