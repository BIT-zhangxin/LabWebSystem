package com.example.labwebsystem.entity;

import lombok.Data;

@Data
public class TeachPaper {
    private Integer id;//教学论文id
    private String title;//题目
    private String conference;//期刊/会议名称
    private String conferenceId;//刊号/会议时间
    private int year;//年份
}
