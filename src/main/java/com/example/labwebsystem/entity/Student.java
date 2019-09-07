package com.example.labwebsystem.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private Integer id;//学生id
    private String studentNumber;//学号
    private String name;//姓名
    private String lastName;//英文姓
    private String firstName;//英文名
    private int sex;//0代表男，1代表女
    private int category;//0代表本科，1代表硕士，2代表博士
    private String nationality;//国籍
    private Date admissionTime;//入学时间，四位年份，两位月份，两位日期
    private String admissionTimeString;//入学时间字符串
    private Date graduationTime;//毕业时间，四位年份，两位月份，两位日期
    private String graduationTimeString;//毕业时间字符串
    private String firstEmploymentUnit;//初次就业单位
    private String tutorNumber;//导师教师工号
    private String assistantTutorNumber;//副导师教师工号
    private Date birthday;//出生日期，四位年份，两位月份，两位日期
    private String birthdayString;//出生日期字符串
    private String email;//电子邮箱
    private String mobilePhone;//移动电话
    private String remarks;//备注
    private String photo;//照片

    public Student(){}

    public Student(UserData userData){
        this.id=userData.getId();
        this.studentNumber=userData.getStudentNumber();
        this.name=userData.getName();
        this.lastName=userData.getLastName();
        this.firstName=userData.getFirstName();
        this.sex=userData.getSex();
        this.category=userData.getCategory();
        this.nationality=userData.getNationality();
        this.admissionTime=userData.getAdmissionTime();
        this.admissionTimeString=userData.getAdmissionTimeString();
        this.graduationTime=userData.getGraduationTime();
        this.graduationTimeString=userData.getGraduationTimeString();
        this.firstEmploymentUnit=userData.getFirstEmploymentUnit();
        this.tutorNumber=userData.getTutorNumber();
        this.assistantTutorNumber=userData.getAssistantTutorNumber();
        this.birthday=userData.getBirthday();
        this.birthdayString=userData.getBirthdayString();
        this.email=userData.getEmail();
        this.mobilePhone=userData.getMobilePhone();
        this.remarks=userData.getRemarks();
        this.photo=userData.getPhoto();
    }
}
