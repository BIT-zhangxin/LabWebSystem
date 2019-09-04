package com.example.labwebsystem.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CheckIn {

    private Integer id;//签到id
    private Timestamp checkinTime;//签到时间
    private Timestamp checkoutTime;//签出时间
    private Integer userId;//签到信息对应用户的id
}
