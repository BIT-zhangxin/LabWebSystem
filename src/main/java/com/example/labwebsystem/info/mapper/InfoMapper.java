package com.example.labwebsystem.info.mapper;

import com.example.labwebsystem.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.core.annotation.Order;

import java.util.List;


@Mapper
@Order(1)
public interface InfoMapper {

    //科研论文
    @Select("SELECT `id` as id, " +
            "`title` as title, " +
            "`conference` as conference, " +
            "`conference_id` as conferenceId, " +
            "`year` as year "+
            "from t_research_paper " +
            "LIMIT #{param1}, #{param2};")
    List<ResearchPaper> selectResearchPaper(int offset, int pageSize);

    @Select("SELECT `id` as id, " +
            "`title` as title, " +
            "`conference` as conference, " +
            "`conference_id` as conferenceId, " +
            "`year` as year "+
            "from t_research_paper " +
            "WHERE title like #{param1} "+
            "OR conference like #{param1} "+
            "LIMIT #{param2}, #{param3};")
    List<ResearchPaper> searchResearchPaper(String condition,int offset, int pageSize);

    //专利
    @Select("SELECT `id` as id, "+"" +
            "`applier` as applier, "+
            "`papent_name` as papentName, "+
            "`papent_apply_id` as papentApplyId "+
            "from t_papent " +
            "LIMIT #{param1}, #{param2};")
    List<Papent> selectPapent(int offset,int pageSize);

    @Select("SELECT `id` as id, "+"" +
            "`applier` as applier, "+
            "`papent_name` as papentName, "+
            "`papent_apply_id` as papentApplyId "+
            "from t_papent " +
            "WHERE papent_name like #{param1} "+
            "OR papent_apply_id like #{param1} "+
            "LIMIT #{param2}, #{param3};")
    List<Papent> searchPapent(String condition,int offset, int pageSize);

    //教材
    @Select("SELECT `id` as id, " +
            "`name` as name, " +
            "`prize_info` as prizeInfo, " +
            "`year` as year " +
            "from t_teach_material " +
            "LIMIT #{param1}, #{param2};")
    List<TeachMaterial> selectTeachMaterial(int offset,int pageSize);

    @Select("SELECT `id` as id, " +
            "`name` as name, " +
            "`prize_info` as prizeInfo, " +
            "`year` as year " +
            "from t_teach_material " +
            "WHERE name like #{param1} "+
            "LIMIT #{param2}, #{param3};")
    List<TeachMaterial> searchTeachMaterial(String condition,int offset, int pageSize);

    //教改
    @Select("SELECT `id` as id, " +
            "`name` as name, " +
            "`level` as level, " +
            "`year` as year " +
            "from t_edu_reform " +
            "LIMIT #{param1}, #{param2};")
    List<EduReform> selectEduReform(int offset,int pageSize);

    @Select("SELECT `id` as id, " +
            "`name` as name, " +
            "`level` as level, " +
            "`year` as year " +
            "from t_edu_reform " +
            "WHERE name like #{param1} "+
            "LIMIT #{param2}, #{param3};")
    List<EduReform> searchEduReform(String condition,int offset, int pageSize);

    //国籍合作
    @Select("SELECT `id` as id, " +
            "`institution_name` as institutionName, " +
            "`country` as country, " +
            "`cooperation_projects` as cooperationProjects " +
            "from t_global_cooperation " +
            "LIMIT #{param1}, #{param2};")
    List<GlobalCooperation> selectGlobalCooperation(int offset,int pageSize);

    @Select("SELECT `id` as id, " +
            "`institution_name` as institutionName, " +
            "`country` as country, " +
            "`cooperation_projects` as cooperationProjects " +
            "from t_global_cooperation " +
            "WHERE institution_name like #{param1} " +
            "OR country like #{param1} " +
            "OR cooperation_projects like #{param1} " +
            "LIMIT #{param2}, #{param3};")
    List<GlobalCooperation> searchGlobalCooperation(String condition,int offset, int pageSize);

    //招生信息
    @Select("SELECT `id` as id, " +
            "`student_type` as studentType, " +
            "`skills_requirement` as skillsRequirement, " +
            "`operating_hours` as operatingHours " +
            "`contact` as contact " +
            "`other` as other " +
            "from t_admissions_information " +
            "WHERE student_type = #{param1} "+
            "LIMIT 1;")
    AdmissionsInformation selectAdmissionsInformation(String type);
}
