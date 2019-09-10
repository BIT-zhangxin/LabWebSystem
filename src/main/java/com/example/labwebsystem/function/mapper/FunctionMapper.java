package com.example.labwebsystem.function.mapper;

import com.example.labwebsystem.entity.Announcement;
import com.example.labwebsystem.entity.Grouping;
import com.example.labwebsystem.entity.UserGrouping;
import org.apache.ibatis.annotations.*;
import org.springframework.core.annotation.Order;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Order(1)
public interface FunctionMapper {

    @Insert("INSERT INTO t_grouping" +
            "(`creator_id`,`name`,`description`,`category`) " +
            "VALUES(#{creatorId},#{name},#{description},#{category});")
    int createGrouping(Grouping grouping);

    @Update("UPDATE t_grouping SET " +
            "`name`=#{name}, " +
            "`description`=#{description} " +
            "WHERE `id`=#{id};")
    int updateGrouping(Grouping grouping);

    @Select("CALL proc_delete_grouping(#{param1});")
    int deleteGrouping(int groupingId);

    @Select("SELECT " +
            "`user_id` AS `id` " +
            "FROM t_user_grouping " +
            "WHERE `grouping_id`=#{param1};")
    List<Integer> selectGroupingMembers(int groupingId);

    @Select("SELECT " +
            "`id` AS `id`, " +
            "`creator_id` AS `creatorId`, " +
            "`name` AS `name`, " +
            "`description` AS `description`, " +
            "`category` AS `category` " +
            "FROM t_grouping " +
            "WHERE (`category`=3) " +
            "OR (`category`=0 AND #{param1} IN (SELECT `user_id` FROM t_user_grouping WHERE t_grouping.`id`=t_user_grouping.`grouping_id`)) " +
            "OR (`category`=(SELECT `category` FROM t_user WHERE `id`=#{param1} LIMIT 1));")
    List<Grouping> selectJoinGrouping(int userId);

    @Select("SELECT " +
            "`id` AS `id`, " +
            "`creator_id` AS `creatorId`, " +
            "`name` AS `name`, " +
            "`description` AS `description`, " +
            "`category` AS `category` " +
            "FROM t_grouping " +
            "WHERE `creator_id`=#{param1};")
    List<Grouping> selectCreateGrouping(int userId);

    @Insert("INSERT INTO t_user_grouping " +
            "(`user_id`,`grouping_id`) " +
            "VALUES(#{userId},#{groupingId});")
    int addGroupingUser(UserGrouping userGrouping);

    @Delete("DELETE FROM t_user_grouping " +
            "WHERE `user_id`=#{userId} AND `grouping_id`=#{groupingId};")
    int deleteGroupingUser(UserGrouping userGrouping);

    @Insert("INSERT INTO t_announcement " +
            "(`title`,`time`,`editor_name`,`content`,`grouping_id`) " +
            "VALUES(#{title},#{time},#{editorName},#{content},#{groupingId});")
    int createAnnouncement(Announcement announcement);

    @Update("UPDATE t_announcement SET " +
            "`title`=#{title}, " +
            "`time`=#{time}, " +
            "`editor_name`=#{editorName}, " +
            "`content`=#{content}, " +
            "`grouping_id`=#{groupingId} " +
            "WHERE `id`=#{id}")
    int updateAnnouncement(Announcement announcement);

    @Select("SELECT " +
            "`id` AS `id`, " +
            "`title` AS `title`, " +
            "`time` AS `time`, " +
            "`editor_name` AS `editorName`, " +
            "`content` AS `content`, " +
            "`grouping_id` AS `groupingId` " +
            "FROM t_announcement " +
            "WHERE `grouping_id`=3 " +
            "OR `grouping_id`=#{param1};")
    List<Announcement> selectJoinAnnouncement(int userId);

    @Select("SELECT " +
            "t_announcement.`id` AS `id`, " +
            "t_announcement.`title` AS `title`, " +
            "t_announcement.`time` AS `time`, " +
            "t_announcement.`editor_name` AS `editorName`, " +
            "t_announcement.`content` AS `content`, " +
            "t_announcement.`grouping_id` AS `groupingId` " +
            "FROM t_announcement,t_grouping " +
            "WHERE t_announcement.`grouping_id`=t_grouping.`id` " +
            "AND t_grouping.`creator_id`=#{param1};")
    List<Announcement> selectCreateAnnouncement(int userId);

    @Delete("DELETE FROM t_announcement " +
            "WHERE `id`=#{param1};")
    int deleteAnnouncement(int announcementId);

    @Select("CALL proc_create_checkin(#{param1},#{param2});")
    int createCheckin(Timestamp now,int userId);

    @Update("UPDATE t_checkin " +
            "SET `checkout_time`=#{param1} " +
            "WHERE `id`=#{param2};")
    int updateCheckin(Timestamp now,int checkinId);
}
