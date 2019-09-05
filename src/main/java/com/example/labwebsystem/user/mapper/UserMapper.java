package com.example.labwebsystem.user.mapper;

import com.example.labwebsystem.entity.Student;
import com.example.labwebsystem.entity.Teacher;
import com.example.labwebsystem.entity.UserData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.core.annotation.Order;

@Mapper
@Order(1)
public interface UserMapper {

    //测试接口
    @Insert("INSERT INTO t_user " +
            "(`id`,`name`,`password`,`category`) " +
            "VALUES(1,'admin',#{param1},4);")
    int insertAdmin(String password);

    @Insert("CALL proc_insert_student(#{password},#{student.studentNumber},#{student.name},#{student.lastName},#{student.firstName}, " +
            "#{student.sex},#{student.category},#{student.nationality},#{student.admissionTime},#{student.graduationTime},#{student.tutorNumber}, " +
            "#{student.assistantTutorNumber},#{student.birthday},#{student.email},#{student.mobilePhone},#{student.remarks},#{student.photo});")
    int insertStudent(Student student,String password);

    @Insert("CALL proc_insert_teacher(#{password},#{teacher.jobNumber},#{teacher.name},#{teacher.lastName},#{teacher.firstName}, " +
            "#{teacher.sex},#{teacher.category},#{teacher.nationality},#{teacher.unit},#{teacher.jobTitle},#{teacher.tutorQualification}, " +
            "#{teacher.position},#{teacher.laboratoryPosition},#{teacher.birthday},#{teacher.email},#{teacher.mobilePhone}, " +
            "#{teacher.officePhone},#{teacher.remarks},#{teacher.photo});")
    int insertTeacher(Teacher teacher, String password);

    @Select("CALL proc_select_user(#{param1});")
    UserData selectUser(int userId);

    @Select("CALL proc_delete_user(#{param1});")
    int deleteUser(int userId);

    @Update("UPDATE t_user " +
            "SET `password`=#{param2} " +
            "WHERE `id`=#{param1};")
    int updatePassword(int userId,String password);
}
