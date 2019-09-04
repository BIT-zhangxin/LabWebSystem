package com.example.labwebsystem.entity;

import lombok.Data;

@Data
public class TeachingInformation {
    private Integer id;//课程id
    private String numbering;//课程编号
    private String name;//课程名称
    private String properties;//课程属性
    private String teacherNumber;//教师工号
    private String teachingTime;//授课时间
    private String studentLevel;//学生层次
}
