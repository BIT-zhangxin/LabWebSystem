package com.example.labwebsystem.security.entity;

import lombok.Data;

@Data
public class UserData {

    private Integer id;//用户id
    private String username;//登录名
    private String name;//用户名
    private String password;//密码
}
