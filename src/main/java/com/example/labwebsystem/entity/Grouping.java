package com.example.labwebsystem.entity;

import lombok.Data;

@Data
public class Grouping {
    private Integer id;//分组id
    private Integer creatorId;//分组创建者id
    private String name;//分组名称
    private String description;//0代表无，1代表学生，2代表教师，3代表全体用户
}
