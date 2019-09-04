package com.example.labwebsystem.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Student {
    private Integer id;//学生id
    private String studentNumber;//学号
    private String name;//姓名
    private String lastName;//英文姓
    private String firstName;//英文名
    private Integer sex;//0代表男，1代表女
    private Integer category;//0代表本科，1代表硕士，2代表博士
    private String nationality;//国籍
    private Date admissionTime;//入学时间，四位年份，两位月份，两位日期
    private Date graduationTime;//毕业时间，四位年份，两位月份，两位日期
    private String firstEmploymentUnit;//初次就业单位
    private String tutorNumber;//导师教师工号
    private String assistantTutorNumber;//副导师教师工号
    private Date birthday;//出生日期，四位年份，两位月份，两位日期
    private String email;//电子邮箱
    private String mobilePhone;//移动电话
    private String remarks;//备注
    private String photo;//照片
}
