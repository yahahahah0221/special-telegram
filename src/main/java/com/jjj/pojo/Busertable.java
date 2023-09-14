package com.jjj.pojo;

public class Busertable {
    Integer id;
    String bemail;
    String bpwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBemail() {
        return bemail;
    }

    public void setBemail(String bemail) {
        this.bemail = bemail;
    }

    public String getBpwd() {
        return bpwd;
    }

    public void setBpwd(String bpwd) {
        this.bpwd = bpwd;
    }

    @Override
    public String toString() {
        return "Busertable{" +
                "id=" + id +
                ", bemail='" + bemail + '\'' +
                ", bpwd='" + bpwd + '\'' +
                '}';
    }
}
