package com.example.labwebsystem.entity;

import lombok.Data;

@Data
public class AdmissionsInformation {
    private Integer id;//招生信息id
    private String studentType;//1代表本科生，2代表硕士生，3代表博士生，4代表留学生
    private String skillsRequirement;//技术要求
    private String operatingHours;//工作时间
    private String contact;//联系方式
    private String other;//其他要求
}
