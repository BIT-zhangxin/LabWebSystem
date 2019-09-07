package com.example.labwebsystem.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Teacher {
    private Integer id;//教师编号
    private String jobNumber;//教师工号
    private String name;//中文姓名
    private String lastName;//英文姓
    private String firstName;//英文名
    private int sex;//0代表男，1代表女
    private int category;//0代表专职，1代表兼职
    private String nationality;//国籍
    private String unit;//单位
    private String jobTitle;//职称，分为正高、副高、中级、初级、无
    private String tutorQualification;//导师资格，分为博导、硕导、无
    private String position;//学院行政职务
    private String laboratoryPosition;//实验室职务
    private Date birthday;//出生日期，四位年份，两位月份，两位日期
    private String birthdayString;//出生日期字符串
    private String email;//电子邮箱
    private String mobilePhone;//移动电话
    private String officePhone;//办公电话
    private String remarks;//备注
    private String photo;//照片

    public Teacher(){}

    public Teacher(UserData userData){
        this.id=userData.getId();
        this.jobNumber=userData.getJobNumber();
        this.name=userData.getName();
        this.lastName=userData.getLastName();
        this.firstName=userData.getFirstName();
        this.sex=userData.getSex();
        this.category=userData.getCategory();
        this.nationality=userData.getNationality();
        this.unit=userData.getUnit();
        this.jobTitle=userData.getJobTitle();
        this.tutorQualification=userData.getTutorQualification();
        this.position=userData.getPosition();
        this.laboratoryPosition=userData.getLaboratoryPosition();
        this.birthday=userData.getBirthday();
        this.birthdayString=userData.getBirthdayString();
        this.email=userData.getEmail();
        this.mobilePhone=userData.getMobilePhone();
        this.officePhone=userData.getOfficePhone();
        this.remarks=userData.getRemarks();
        this.photo=userData.getPhoto();
    }
}
