package com.example.labwebsystem.entity;

import lombok.Data;

@Data
public class Papent {
    private Integer id;//专利编号
    private String applier;//专利申请人
    private String papentName;//专利名称
    private String papentApplyId;//专利申请号
}
