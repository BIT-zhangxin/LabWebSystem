package com.example.labwebsystem.entity;

import lombok.Data;

@Data
public class Annex {
    private Integer id;//附件id
    private String fileName;//文件名称
    private String path;//文件路径
    private Integer size;//文件大小
    private Integer dynamicId;//对应动态id
}
