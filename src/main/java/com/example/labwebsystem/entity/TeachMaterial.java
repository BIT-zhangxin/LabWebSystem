package com.example.labwebsystem.entity;

import lombok.Data;

@Data
public class TeachMaterial {
    private Integer id;//教材编号
    private String name;//名称
    private String prizeInfo;//获奖信息
    private Integer year;//出版年份
}
