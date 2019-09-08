package com.example.labwebsystem.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class Dynamic {
    private Integer id;//动态id
    private String title;//动态标题
    private Timestamp time;//动态编辑时间
    private String editorName;//编辑人姓名
    private String content;//动态内容
    private int category;//0代表照片墙，1代表通知公告，2代表新闻动态，3代表学术活动，4代表下载中心

    public int getId(){
        return id;
    }
    public void setTime(){
        this.time=new Timestamp(new Date().getTime());
    }
}
