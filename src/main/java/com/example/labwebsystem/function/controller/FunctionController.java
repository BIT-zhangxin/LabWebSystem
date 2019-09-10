package com.example.labwebsystem.function.controller;

import com.example.labwebsystem.entity.Announcement;
import com.example.labwebsystem.entity.Grouping;
import com.example.labwebsystem.entity.UserGrouping;
import com.example.labwebsystem.function.mapper.FunctionMapper;
import com.example.labwebsystem.function.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping(value="/function", method = {RequestMethod.POST,RequestMethod.GET})
public class FunctionController {

    @Autowired
    FunctionService functionService;

    @Autowired
    FunctionMapper functionMapper;

    //创建分组
    @RequestMapping("/createGrouping")
    public int createGrouping(Grouping grouping){
        return functionMapper.createGrouping(grouping);
    }

    //更新分组信息
    @RequestMapping("/updateGrouping")
    public int updateGrouping(Grouping grouping){
        return functionMapper.updateGrouping(grouping);
    }

    //删除分组
    @RequestMapping("/deleteGrouping")
    public int deleteGrouping(int groupingId){
        return functionMapper.deleteGrouping(groupingId);
    }

    //查询分组成员
    @RequestMapping("/selectGroupingMembers")
    public List<Integer> selectGroupingMembers(int groupingId){
        return functionMapper.selectGroupingMembers(groupingId);
    }

    //查询加入的分组
    @RequestMapping("/selectJoinGrouping")
    public List<Grouping> selectJoinGrouping(int userId){
        return functionMapper.selectJoinGrouping(userId);
    }

    //查询创建的分组
    @RequestMapping("/selectCreateGrouping")
    public List<Grouping> selectCreateGrouping(int userId){
        return functionMapper.selectCreateGrouping(userId);
    }

    //批量添加分组成员
    @RequestMapping("/addGroupingUsers")
    public int addGroupingUsers(@RequestBody List<UserGrouping> listUserGrouping){
        try {
            return functionService.addGroupingUsers(listUserGrouping);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    //批量删除分组成员
    @RequestMapping("/deleteGroupingUsers")
    public int deleteGroupingUsers(@RequestBody List<UserGrouping> listUserGrouping){
        try {
            return functionService.deleteGroupingUsers(listUserGrouping);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    //创建通知
    @RequestMapping("/createAnnouncement")
    public int createAnnouncement(Announcement announcement){
        LocalDate localDate = LocalDate.now();
        Timestamp now= Timestamp.valueOf(LocalDateTime.now());
        announcement.setTime(now);
        return functionMapper.createAnnouncement(announcement);
    }

    //更新通知
    @RequestMapping("/updateAnnouncement")
    public int updateAnnouncement(Announcement announcement){
        LocalDate localDate = LocalDate.now();
        Timestamp now= Timestamp.valueOf(LocalDateTime.now());
        announcement.setTime(now);
        return functionMapper.updateAnnouncement(announcement);
    }

    //查询加入的分组的通知
    @RequestMapping("/selectJoinAnnouncement")
    public List<Announcement> selectJoinAnnouncement(int userId){
        return functionMapper.selectJoinAnnouncement(userId);
    }

    //查询创建的通知
    @RequestMapping("/selectCreateAnnouncement")
    public List<Announcement> selectCreateAnnouncement(int userId){
        return functionMapper.selectCreateAnnouncement(userId);
    }

    //删除通知
    @RequestMapping("/deleteAnnouncement")
    public int deleteAnnouncement(int announcementId){
        return functionMapper.deleteAnnouncement(announcementId);
    }

    //签到
    @RequestMapping("/createCheckin")
    public int createCheckin(int userId){
        LocalDate localDate = LocalDate.now();
        Timestamp now= Timestamp.valueOf(LocalDateTime.now());
        return functionMapper.createCheckin(now,userId);
    }

    //更新签到
    @RequestMapping("/updateCheckin")
    public int updateCheckin(int checkinId){
        LocalDate localDate = LocalDate.now();
        Timestamp now= Timestamp.valueOf(LocalDateTime.now());
        return functionMapper.updateCheckin(now,checkinId);
    }
}
