package com.jjj.pojo;

import org.springframework.web.multipart.MultipartFile;

public class Goods {
    int id;
    String gname;
    double goprice;
    double grprice;
    int gstore;
    MultipartFile logoImage;
    String gpicture;
    int goodstype_id;
    String typename;

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", gname='" + gname + '\'' +
                ", goprice=" + goprice +
                ", grprice=" + grprice +
                ", gstore=" + gstore +
                ", logoImage=" + logoImage +
                ", gpicture='" + gpicture + '\'' +
                ", goodstype_id=" + goodstype_id +
                ", typename='" + typename + '\'' +
                '}';
    }

    public String getGpicture() {
        return gpicture;
    }

    public void setGpicture(String gpicture) {
        this.gpicture = gpicture;
    }

    public MultipartFile getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(MultipartFile logoImage) {
        this.logoImage = logoImage;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Goods() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public double getGoprice() {
        return goprice;
    }

    public void setGoprice(double goprice) {
        this.goprice = goprice;
    }

    public double getGrprice() {
        return grprice;
    }

    public void setGrprice(double grprice) {
        this.grprice = grprice;
    }

    public int getGstore() {
        return gstore;
    }

    public void setGstore(int gstore) {
        this.gstore = gstore;
    }



    public int getGoodstype_id() {
        return goodstype_id;
    }

    public void setGoodstype_id(int goodstype_id) {
        this.goodstype_id = goodstype_id;
    }
}
