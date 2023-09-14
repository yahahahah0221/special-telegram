package com.jjj.pojo;

import java.sql.Timestamp;

public class Notice {
    int id;
    String ntitle;
    String ncontent;
    Timestamp ntime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    public Timestamp getNtime() {
        return ntime;
    }

    public void setNtime(Timestamp ntime) {
        this.ntime = ntime;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", ntitle='" + ntitle + '\'' +
                ", ncontent='" + ncontent + '\'' +
                ", ntime=" + ntime +
                '}';
    }
}
