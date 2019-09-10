package com.example.labwebsystem.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Annex {
    private Integer id;//附件id
    private String fileName;//文件名称
    private String path;//文件路径
    private String content;//文件描述
    private Timestamp time;//创建时间
}
