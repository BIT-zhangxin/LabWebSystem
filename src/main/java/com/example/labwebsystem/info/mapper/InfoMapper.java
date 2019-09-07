package com.example.labwebsystem.info.mapper;

import com.example.labwebsystem.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.core.annotation.Order;

import java.util.List;

@Mapper
@Order(1)
public interface InfoMapper {

    //潘恋军
    //对t_teacher表格操作
    @Select("SELECT id,job_number as jobNumber,name,last_name as lastName,first_name as firstName," +
            "sex,category,nationality,unit,job_title as jobTitle ,tutor_qualification as tutorQualification" +
            "position,laboratory_position as laboratoryPosition,birthday,email,mobile_phone as mobilePhone,office_phone as officePhone ,remarks,photo " +
            "from t_teacher WHERE category` = #{param1};")
    List<Teacher> selectTeacher(int category);

    //对t_student表格进行操作
    @Select("SELECT id,student_number as studentNumber,name,last_name as lastName ,first_name as firstName," +
            "sex,category,nationality,admission_time as admissionTime,graduation_time as graduationTime," +
            "first_employment_unit as firstEmploymentUnit,tutor_number as tutorNumber,assistant_tutor_number as assistantTutorNumber," +
            "birthday,email,mobile_phone as mobilePhone,remarks,photo " +
            "from t_student WHERE `graduation_time` > now();")
    List<Student> selectGraduate();

    //对t_static_content表格进行操作
    @Select("SELECT * FROM t_static_content WHERE `t_static_content`.id = #{param1};")
    StaticContent selectStaticContent(int staticContentId);

    //对t_dynamic表格操作
    @Select("SELECT `id`,`title` ,`time`,`editor_name` as editorName ,`content`,`category` " +
            "FROM t_dynamic " +
            "WHERE `category` = #{param1};")
    List<Dynamic> selectDynamicByType(int type);

    @Select("SELECT `id`,`title` ,`time`,`editor_name` as editorName ,`content`,`category` " +
            "FROM t_dynamic " +
            "WHERE t_dynamic.`id` = #{param1};")
    Dynamic selectDynamic(int dynamicId);

    @Select("SELECT `id`,`title` ,`time`,`editor_name` as editorName ,`content`,`category` " +
            "FROM t_dynamic WHERE " +
            "WHERE (`title` like %#{param2}% or `content` like %#{param2}%) AND `category' = #{param1};")
    List<Dynamic> selectDynamicByCondition(int type,String condition);

    //对t_teaching_information表格操作
    @Select("SELECT `id`,`numbering`,`name`,`properties`,`teacher_number` as teacherNumber,`teaching_time` as teachingTime,`student_level` as studentLevel " +
            "FROM t_teaching_information;")
    List<TeachingInformation> selectTeachingInformation();

    @Select("SELECT `id`,`numbering`,`name`,`properties`,`teacher_number` as teacherNumber,`teaching_time` as teachingTime,`student_level` as studentLevel " +
            "FROM t_teaching_information " +
            "WHERE `name` like %#{param1}% or `teaching_time` like %#{param1}% or `student_level` like %#{param1}%;")
    List<TeachingInformation> selectTeachingInformationByCondition(String condition);

    //对t_scientific_information表格操作
    @Select("SELECT `id`,`properties`,`name`,`teacher_number` as teacherNumber " +
            "FROM t_scientific_information;")
    List<ScientificInformation> selectScientificInformation();

    @Select("SELECT `id`,`properties`,`name`,`teacher_number` as teacherNumber " +
            "FROM t_scientific_information " +
            "WHERE `name` like %#{param1}% or `teacher_number` like %#{param1}%;")
    List<ScientificInformation> selectScientificInformationByCondition(String condition);

    //对t_research_result表格操作
    @Select("SELECT * FROM t_research_result;")
    List<ResearchResult> selectResearchResult();

    @Select("SELECT * FROM t_research_result WHERE `name` like %#{param1}%;")
    List<ResearchResult> selectResearchResultByCondition(String condition);

    //对t_teach_result表格操作
    @Select("SELECT * FROM t_teach_result;")
    List<TeachResult> selectTeachResult();

    @Select("SELECT * FROM t_teach_result WHERE `name` like %#{param1}%;")
    List<TeachResult> selectTeachResultByCondition(String condition);

    //对t_teach_paper表格操作
    @Select("SELECT `id`,`title`,`conference`,`conference_id` as conferenceId,`year` " +
            "FROM t_teach_paper;")
    List<TeachPaper> selectTeachPaper();

    @Select("SELECT `id`,`title`,`conference`,`conference_id` as conferenceId,`year` " +
            "FROM t_teach_paper " +
            "WHERE `title` like %#{param1}% or `conference` like %#{param1}%;")
    List<TeachPaper> selectTeachPaperByCondition(String condition);







    //何祎君
    //科研论文
    @Select("SELECT `id` as id, " +
            "`title` as title, " +
            "`conference` as conference, " +
            "`conference_id` as conferenceId, " +
            "`year` as year "+
            "from t_research_paper;")
    List<ResearchPaper> selectResearchPaper();

    @Select("SELECT `id` as id, " +
            "`title` as title, " +
            "`conference` as conference, " +
            "`conference_id` as conferenceId, " +
            "`year` as year "+
            "from t_research_paper " +
            "WHERE title like %#{param1}% "+
            "OR conference like %#{param1}%;")
    List<ResearchPaper> selectResearchPaperMyCondition(String condition);

    //专利
    @Select("SELECT `id` as id, "+"" +
            "`applier` as applier, "+
            "`papent_name` as papentName, "+
            "`papent_apply_id` as papentApplyId "+
            "from t_papent;")
    List<Papent> selectPapent();

    @Select("SELECT `id` as id, "+"" +
            "`applier` as applier, "+
            "`papent_name` as papentName, "+
            "`papent_apply_id` as papentApplyId "+
            "from t_papent " +
            "WHERE papent_name like %#{param1}% "+
            "OR papent_apply_id like %#{param1}%;")
    List<Papent> selectPapentMyCondition(String condition);

    //教材
    @Select("SELECT `id` as id, " +
            "`name` as name, " +
            "`prize_info` as prizeInfo, " +
            "`year` as year " +
            "from t_teach_material;")
    List<TeachMaterial> selectTeachMaterial();

    @Select("SELECT `id` as id, " +
            "`name` as name, " +
            "`prize_info` as prizeInfo, " +
            "`year` as year " +
            "from t_teach_material " +
            "WHERE name like %#{param1}%;")
    List<TeachMaterial> selectTeachMaterialMyCondition(String condition);

    //教改
    @Select("SELECT `id` as id, " +
            "`name` as name, " +
            "`level` as level, " +
            "`year` as year " +
            "from t_edu_reform;")
    List<EduReform> selectEduReform();

    @Select("SELECT `id` as id, " +
            "`name` as name, " +
            "`level` as level, " +
            "`year` as year " +
            "from t_edu_reform " +
            "WHERE name like %#{param1}%;")
    List<EduReform> selectEduReformMyCondition(String condition);

    //国籍合作
    @Select("SELECT `id` as id, " +
            "`institution_name` as institutionName, " +
            "`country` as country, " +
            "`cooperation_projects` as cooperationProjects " +
            "from t_global_cooperation;")
    List<GlobalCooperation> selectGlobalCooperation();

    @Select("SELECT `id` as id, " +
            "`institution_name` as institutionName, " +
            "`country` as country, " +
            "`cooperation_projects` as cooperationProjects " +
            "from t_global_cooperation " +
            "WHERE institution_name like %#{param1}% " +
            "OR country like %#{param1}% " +
            "OR cooperation_projects like %#{param1}%;")
    List<GlobalCooperation> selectGlobalCooperationMyCondition(String condition);

    //招生信息
    @Select("SELECT `id` as id, " +
            "`student_type` as studentType, " +
            "`skills_requirement` as skillsRequirement, " +
            "`operating_hours` as operatingHours " +
            "`contact` as contact " +
            "`other` as other " +
            "from t_admissions_information " +
            "WHERE student_type = #{param1} LIMIT 1;")
    AdmissionsInformation selectAdmissionsInformation(String type);

    @Select("SELECT `id` as id, " +
            "`file_name` as fileName, " +
            "`path` as path, " +
            "`size` as size " +
            "`dynamic_id` as dynamicId " +
            "from t_annex " +
            "WHERE dynamic_id = #{param1};")
    List<Annex> selectAnnex(int dynamicId);
}
