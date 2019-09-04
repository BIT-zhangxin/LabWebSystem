package com.example.labwebsystem.entity;

import lombok.Data;

@Data
public class CopyRight {
    private Integer id;//著作权id
    private String code;//著作权编号
    private String righter;//著作权人
    private String rightName;//著作权名称
    private String signedId;//登记号
}
