package com.example.labwebsystem.user.mapper;

import com.example.labwebsystem.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.core.annotation.Order;

import java.util.List;

@Mapper
@Order(1)
public interface UserMapper {

    //sql是我从别的项目粘的，看看格式
    //TODO:修改sql
    @Insert("INSERT INTO t_record_info " +
            "(`region_emp_id`,`region_emp_name`,`reviser`,`delete_flag`) " +
            "VALUES(#{regionEmpId},#{regionEmpName},#{reviser},0);")
    int insertStudent(Student student);

    @Update("UPDATE t_record_info SET " +
            "`region_emp_id`=#{regionEmpId}, " +
            "`region_emp_name`=#{regionEmpName}, " +
            "`reviser`=#{reviser} " +
            "WHERE `region_emp_id`=#{regionEmpId} " +
            "AND `state_flag`=0;")
    int updateStudent(Student student);

    //如果查询内容确定只有一条可以添加LIMIT 1来优化
    @Select("SELECT " +
            "`region_emp_id` AS regionEmpId, " +
            "`region_emp_name` AS regionEmpName, " +
            "`reviser` AS reviser " +
            "FROM `t_record_info` " +
            "WHERE `delete_flag`=0 " +
            "AND `state_flag`=2 " +
            "AND `region_emp_id`=#{param1} " +
            "AND `region_emp_name` LIKE %#{param2}%;")
    List<Student> selectStudent(int currentPage, int pageSize);

    @Delete("DELETE FROM `t_record_info` " +
            "WHERE `region_emp_id`=#{regionEmpId} " +
            "AND `state_flag`=0;")
    int deleteStudent(int userId);
}
