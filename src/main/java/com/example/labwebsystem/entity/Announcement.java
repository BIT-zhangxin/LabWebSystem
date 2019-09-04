package com.example.labwebsystem.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Announcement {
    private Integer id;//通知id
    private String title;//通知标题
    private Timestamp time;//通知编辑时间
    private String editorName;//编辑人姓名
    private String content;//通知内容
    private Integer groupingId;//对应分组id
}
