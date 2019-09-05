package com.example.labwebsystem.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserData {
    private int userType;
    private Integer id;
    private String name;
    private String lastName;
    private String firstName;
    private int sex;
    private int category;
    private String nationality;
    private Date birthday;
    private String birthdayString;
    private String email;
    private String mobilePhone;
    private String remarks;
    private String photo;
    private String jobNumber;
    private String unit;
    private String jobTitle;
    private String tutorQualification;
    private String position;
    private String laboratoryPosition;
    private String officePhone;
    private String studentNumber;
    private Date admissionTime;
    private String admissionTimeString;
    private Date graduationTime;
    private String graduationTimeString;
    private String firstEmploymentUnit;
    private String tutor;
    private String assistantTutor;
}
