package com.example.labwebsystem.entity;

import lombok.Data;

@Data
public class User {

    private Integer id;//用户id
    private String name;//用户名
    private String password;//密码
    private int category;//用户类型，1代表教师，2代表学生，3代表实验室主任，4代表系统管理员
}
