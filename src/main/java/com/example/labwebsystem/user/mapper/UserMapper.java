package com.example.labwebsystem.user.mapper;

import com.example.labwebsystem.entity.Student;
import com.example.labwebsystem.entity.Teacher;
import com.example.labwebsystem.entity.User;
import com.example.labwebsystem.entity.UserData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.core.annotation.Order;

import java.util.List;

@Mapper
@Order(1)
public interface UserMapper {

    //测试接口
    @Insert("INSERT INTO t_user " +
            "(`id`,`name`,`password`,`category`) " +
            "VALUES(1,'admin',#{param1},4);")
    int insertAdmin(String password);

    @Select("SELECT " +
            "`id` as id, " +
            "`name` as name, " +
            "`password` as password, " +
            "`category` as category " +
            "FROM t_user " +
            "WHERE `name`=#{param1};")
    User login(String name);

    @Select("SELECT " +
            "`password` as password " +
            "FROM t_user " +
            "WHERE `id`=#{param1};")
    String selectPassword(int userId);

    @Update("UPDATE t_user " +
            "SET `password`=#{param2} " +
            "WHERE `id`=#{param1};")
    int updatePassword(int userId,String password);

    @Select("CALL proc_insert_student(#{password},#{student.studentNumber},#{student.name},#{student.lastName},#{student.firstName}, " +
            "#{student.sex},#{student.category},#{student.nationality},#{student.admissionTime},#{student.graduationTime},#{student.tutorNumber}, " +
            "#{student.assistantTutorNumber},#{student.birthday},#{student.email},#{student.mobilePhone},#{student.remarks},#{student.photo});")
    int insertStudent(Student student,String password);

    @Update("UPDATE t_student SET " +
            "student_number=#{studentNumber}, " +
            "name=#{name}, " +
            "last_name=#{lastName}, " +
            "first_name=#{firstName}, " +
            "sex=#{sex}, " +
            "category=#{category}, " +
            "nationality=#{nationality}, " +
            "admission_time=#{admissionTime}, " +
            "graduation_time=#{graduationTime}, " +
            "first_employment_unit=#{firstEmploymentUnit}, " +
            "tutor_number=#{tutorNumber}, " +
            "assistant_tutor_number=#{assistantTutorNumber}, " +
            "birthday=#{birthday}, " +
            "email=#{email}, " +
            "mobile_phone=#{mobilePhone}, " +
            "remarks=#{remarks}, " +
            "photo=#{photo} " +
            "WHERE t_student.`id`=#{id};")
    int updateStudent(Student student);

    @Select("SELECT " +
            "`id` AS `id`,\n" +
            "`student_number` AS `studentNumber`,\n" +
            "`name` AS `name`,\n" +
            "`last_name` AS `lastName`,\n" +
            "`first_name` AS `firstName`,\n" +
            "`sex` AS `sex`,\n" +
            "`category` AS `category`,\n" +
            "`nationality` AS `nationality`,\n" +
            "`admission_time` AS `admissionTime`,\n" +
            "`graduation_time` AS `graduationTIme`,\n" +
            "`first_employment_unit` AS `firstEmploymentUnit`,\n" +
            "`tutor_number` AS `tutorNumber`,\n" +
            "`assistant_tutor_number` AS `assistantTutorNumber`,\n" +
            "`birthday` AS `birthday`,\n" +
            "`email` AS `email`,\n" +
            "`mobile_phone` AS `mobilePhone`,\n" +
            "`remarks` AS `remarks`,\n" +
            "`photo` AS `photo` " +
            "FROM t_student;")
    List<Student> selectStudent();

    @Select("SELECT " +
            "`id` AS `id`,\n" +
            "`student_number` AS `studentNumber`,\n" +
            "`name` AS `name`,\n" +
            "`last_name` AS `lastName`,\n" +
            "`first_name` AS `firstName`,\n" +
            "`sex` AS `sex`,\n" +
            "`category` AS `category`,\n" +
            "`nationality` AS `nationality`,\n" +
            "`admission_time` AS `admissionTime`,\n" +
            "`graduation_time` AS `graduationTIme`,\n" +
            "`first_employment_unit` AS `firstEmploymentUnit`,\n" +
            "`tutor_number` AS `tutorNumber`,\n" +
            "`assistant_tutor_number` AS `assistantTutorNumber`,\n" +
            "`birthday` AS `birthday`,\n" +
            "`email` AS `email`,\n" +
            "`mobile_phone` AS `mobilePhone`,\n" +
            "`remarks` AS `remarks`,\n" +
            "`photo` AS `photo` " +
            "FROM t_student " +
            "WHERE graduation_time > now();")
    List<Student> selectUnderGraduatedStudent();

    @Select("SELECT " +
            "`id` AS `id`,\n" +
            "`student_number` AS `studentNumber`,\n" +
            "`name` AS `name`,\n" +
            "`last_name` AS `lastName`,\n" +
            "`first_name` AS `firstName`,\n" +
            "`sex` AS `sex`,\n" +
            "`category` AS `category`,\n" +
            "`nationality` AS `nationality`,\n" +
            "`admission_time` AS `admissionTime`,\n" +
            "`graduation_time` AS `graduationTIme`,\n" +
            "`first_employment_unit` AS `firstEmploymentUnit`,\n" +
            "`tutor_number` AS `tutorNumber`,\n" +
            "`assistant_tutor_number` AS `assistantTutorNumber`,\n" +
            "`birthday` AS `birthday`,\n" +
            "`email` AS `email`,\n" +
            "`mobile_phone` AS `mobilePhone`,\n" +
            "`remarks` AS `remarks`,\n" +
            "`photo` AS `photo` " +
            "FROM t_student " +
            "WHERE graduation_time <= now();")
    List<Student> selectGraduatedStudent();

    @Select("SELECT " +
            "`id` AS `id`,\n" +
            "`student_number` AS `studentNumber`,\n" +
            "`name` AS `name`,\n" +
            "`last_name` AS `lastName`,\n" +
            "`first_name` AS `firstName`,\n" +
            "`sex` AS `sex`,\n" +
            "`category` AS `category`,\n" +
            "`nationality` AS `nationality`,\n" +
            "`admission_time` AS `admissionTime`,\n" +
            "`graduation_time` AS `graduationTIme`,\n" +
            "`first_employment_unit` AS `firstEmploymentUnit`,\n" +
            "`tutor_number` AS `tutorNumber`,\n" +
            "`assistant_tutor_number` AS `assistantTutorNumber`,\n" +
            "`birthday` AS `birthday`,\n" +
            "`email` AS `email`,\n" +
            "`mobile_phone` AS `mobilePhone`,\n" +
            "`remarks` AS `remarks`,\n" +
            "`photo` AS `photo` " +
            "FROM t_student " +
            "WHERE student_number=#{param1} OR name LIKE #{param2};")
    List<Student> selectStudentByCondition(String condition1,String condition2);

    @Select("CALL proc_insert_teacher(#{password},#{teacher.jobNumber},#{teacher.name},#{teacher.lastName},#{teacher.firstName}, " +
            "#{teacher.sex},#{teacher.category},#{teacher.nationality},#{teacher.unit},#{teacher.jobTitle},#{teacher.tutorQualification}, " +
            "#{teacher.position},#{teacher.laboratoryPosition},#{teacher.birthday},#{teacher.email},#{teacher.mobilePhone}, " +
            "#{teacher.officePhone},#{teacher.remarks},#{teacher.photo});")
    int insertTeacher(Teacher teacher, String password);

    @Update("UPDATE t_teacher SET " +
            "job_number=#{jobNumber}, " +
            "name=#{name}, " +
            "last_name=#{lastName}, " +
            "first_name=#{firstName}, " +
            "sex=#{sex}, " +
            "category=#{category}, " +
            "nationality=#{nationality}, " +
            "unit=#{unit}, " +
            "job_title=#{jobTitle}, " +
            "tutor_qualification=#{tutorQualification}, " +
            "position=#{position}, " +
            "laboratory_position=#{laboratoryPosition}, " +
            "birthday=#{birthday}, " +
            "email=#{email}, " +
            "mobile_phone=#{mobilePhone}, " +
            "office_phone=#{officePhone}, " +
            "remarks=#{remarks}, " +
            "photo=#{photo} " +
            "WHERE t_teacher.`id`=#{id};")
    int updateTeacher(Teacher teacher);

    @Select("SELECT " +
            "`id` AS `id`,\n" +
            "`job_number` AS `jobNumber`,\n" +
            "`name` AS `name`,\n" +
            "`last_name` AS `lastName`,\n" +
            "`first_name` AS `firstName`,\n" +
            "`sex` AS `sex`,\n" +
            "`category` AS `category`,\n" +
            "`nationality` AS `nationality`,\n" +
            "`unit` AS `unit`,\n" +
            "`job_title` AS `jobTitle`,\n" +
            "`tutor_qualification` AS `tutorQualification`,\n" +
            "`position` AS `position`,\n" +
            "`laboratory_position` AS `laboratoryPosition`,\n" +
            "`birthday` AS `birthday`,\n" +
            "`email` AS `email`,\n" +
            "`mobile_phone` AS `mobilePhone`,\n" +
            "`office_phone` AS `officePhone`,\n" +
            "`remarks` AS `remarks`,\n" +
            "`photo` AS `photo` " +
            "FROM t_teacher;")
    List<Teacher> selectTeacher();

    @Select("SELECT " +
            "`id` AS `id`,\n" +
            "`job_number` AS `jobNumber`,\n" +
            "`name` AS `name`,\n" +
            "`last_name` AS `lastName`,\n" +
            "`first_name` AS `firstName`,\n" +
            "`sex` AS `sex`,\n" +
            "`category` AS `category`,\n" +
            "`nationality` AS `nationality`,\n" +
            "`unit` AS `unit`,\n" +
            "`job_title` AS `jobTitle`,\n" +
            "`tutor_qualification` AS `tutorQualification`,\n" +
            "`position` AS `position`,\n" +
            "`laboratory_position` AS `laboratoryPosition`,\n" +
            "`birthday` AS `birthday`,\n" +
            "`email` AS `email`,\n" +
            "`mobile_phone` AS `mobilePhone`,\n" +
            "`office_phone` AS `officePhone`,\n" +
            "`remarks` AS `remarks`,\n" +
            "`photo` AS `photo` " +
            "FROM t_teacher " +
            "WHERE job_number=#{param1} OR name LIKE #{param2};")
    List<Teacher> selectTeacherByCondition(String condition1,String condition2);

    @Select("SELECT name FROM t_teacher WHERE id=#{param1};")
    String selectTeacherName(int userId);

    @Select("SELECT name FROM t_student WHERE id=#{param1};")
    String selectStudentName(int userId);

    @Select("CALL proc_select_user(#{param1});")
    UserData selectUser(int userId);

    @Select("CALL proc_delete_user(#{param1});")
    int deleteUser(int userId);
}
