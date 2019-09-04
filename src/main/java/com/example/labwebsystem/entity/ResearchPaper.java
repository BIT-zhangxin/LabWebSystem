package com.example.labwebsystem.entity;

import lombok.Data;

@Data
public class ResearchPaper {
    private Integer id;//科研论文id
    private String title;//题目
    private String conference;//期刊/会议名称
    private String conferenceId;//刊号/会议时间
    private String year;//年份
}
