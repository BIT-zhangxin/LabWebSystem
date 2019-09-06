package com.example.labwebsystem.info.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.core.annotation.Order;
import com.example.labwebsystem.entity.*;

import java.util.Date;
import java.util.List;

@Mapper
@Order(1)
public interface InfoMapper {

    //对t_teacher表格操作
    @Select("SELECT id,job_number as jobNumber,name,last_name as lastName,first_name as firstName," +
            "sex,category,nationality,unit,job_title as jobTitle ,tutor_qualification as tutorQualification" +
            "position,laboratory_position as laboratoryPosition,birthday,email,mobile_phone as mobilePhone,office_phone as officePhone ,remarks,photo" +
            "from t_teacher WHERE category` = #{param1}")
    List<Teacher> selectTeacher(int category);

    //对t_student表格进行操作
    @Select("SELECT id,student_number as studentNumber,name,last_name as lastName ,first_name as firstName," +
            "sex,category,nationality,admission_time as admissionTime,graduation_time as graduationTime," +
            "first_employment_unit as firstEmploymentUnit,tutor_number as tutorNumber,assistant_tutor_number as assistantTutorNumber," +
            "birthday,email,mobile_phone as mobilePhone,remarks,photo" +
            "from t_student WHERE `graduation_time` > now()")
    List<Student> selectGraduate();

    //对t_static_content表格进行操作
    @Select("SELECT * FROM t_static_content WHERE `t_static_content`.id = #{param1}")
    StaticContent selectStaticContent(int staticContentId);

    //对t_dynamic表格操作
    @Select("SELECT `id`,`title` ,`time`,`editor_name` as editorName ,`content`,`category`" +
            "FROM t_dynamic limit offset,pageSize" +
            "WHERE `category` = #{param1}")
    List<Dynamic> selectDynamicByType(int type,int offset,int pageSize);
    @Select("SELECT `id`,`title` ,`time`,`editor_name` as editorName ,`content`,`category`" +
            "FROM t_dynamic" +
            "WHERE t_dynamic.`id` = #{param1}")
    Dynamic selectDynamic(int dynamicId);
    @Select("SELECT `id`,`title` ,`time`,`editor_name` as editorName ,`content`,`category`" +
            "FROM t_dynamic WHERE" +
            "WHERE (`title` like %#{param2}% or `content` like %#{param2}%) AND `category' = #{param1}"
    )
    List<Dynamic> selectDynamicByCondition(int type,String condition);

    //对t_teaching_information表格操作
    @Select("SELECT `id`,`numbering`,`name`,`properties`,`teacher_number` as teacherNumber,`teaching_time`,`student_level` as student_Level" +
            "FROM t_teaching_information LIMIT offset,pageSize")
    List<TeachingInformation> selectTeachingInformation(int offset,int pageSize);
    @Select("SELECT `id`,`numbering`,`name`,`properties`,`teacher_number` as teacherNumber,`teaching_time`,`student_level` as student_Level" +
            "FROM t_teaching_information" +
            "WHERE `name` like %#{param1}% or `teaching_time` like %#{param1}% or `student_level` like %#{param1}%"
    )
    List<TeachingInformation> selectTeachingInformationByCondition(String condition);

    //对t_scientific_information表格操作
    @Select("SELECT `id`,`properties`,`name`,`teacherNumber`" +
            "FROM t_scientific_information LIMIT offset,pageSize")
    List<ScientificInformation> selectScientificInformation(int offset,int pageSize);
    @Select("SELECT `id`,`properties`,`name`,`teacherNumber`" +
            "FROM t_scientific_information" +
            "WHERE `name` like %#{param1}% or `teacher_number` like %#{param1}%")
    List<ScientificInformation> selectScientificInformationByCondition(String condition);

    //对t_research_result表格操作
    @Select("SELECT * FROM t_research_result LIMIT offset,pageSize")
    List<ResearchResult> selectResearchResult(int offset,int pageSize);
    @Select("SELECT * FROM t_research_result WHERE `name` like %#{param1}%")
    List<ResearchResult> selectResearchResultByCondition(String condition);

    //对t_teach_result表格操作
    @Select("SELECT * FROM t_teach_result LIMIT offset,pageSize")
    List<TeachResult> selectTeachResult(int offset,int pageSize);
    @Select("SELECT * FROM t_teach_result WHERE `name` like %#{param1}% ")
    List<TeachResult> selectTeachResultByCondition(String condition);

    //对t_research_paper表格操作
    @Select("SELECT `id`,`title`,`conference`,`conference_id` as conferenceId,`year`" +
            "FROM t_research_paper LIMIT offset,pageSize")
    List<ResearchPaper> selectResearchPaper(int offset,int pageSize);
    @Select("SELECT `id`,`title`,`conference`,`conference_id` as conferenceId,`year`" +
            "FROM t_research_paper" +
            "WHERE `title` like %#{param1}% or `conference` like %#{param1}%")
    List<ResearchPaper> selectResearchPaperByCondition(String condition);

    //对t_teach_paper表格操作
    @Select("SELECT `id`,`title`,`conference`,`conference_id` as conferenceId,`year`" +
            "FROM t_teach_paper LIMIT offset,pageSize")
    List<TeachPaper> selectTeachPaper(int offset,int pageSize);
    @Select("SELECT `id`,`title`,`conference`,`conference_id` as conferenceId,`year`" +
            "FROM t_teach_paper" +
            "WHERE `title` like %#{param1}% or `conference` like %#{param1}%")
    List<TeachPaper> selectTeachPaperByCondition(String condition);


}
