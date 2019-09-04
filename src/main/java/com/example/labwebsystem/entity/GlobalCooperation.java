package com.example.labwebsystem.entity;

import lombok.Data;

@Data
public class GlobalCooperation {
    private Integer id;//国际合作id
    private String institutionName;//机构名称
    private String country;//所属国家
    private String cooperationProjects;//合作项目
}
