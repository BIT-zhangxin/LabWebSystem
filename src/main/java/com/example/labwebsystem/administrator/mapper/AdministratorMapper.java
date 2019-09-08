package com.example.labwebsystem.administrator.mapper;

import com.example.labwebsystem.entity.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.core.annotation.Order;

@Mapper
@Order(1)
public interface AdministratorMapper {

    //潘恋军
    @Update("UPDATE t_static_content SET " +
            "`title` = #{title}, " +
            "`content` = #{content} " +
            "WHERE `t_static_content`.`id` = #{id};")
    int updateStaticContent(StaticContent staticContent);

    @Insert("INSERT INTO t_dynamic"+
            "(`title`,`time`,`editor_name`,`content`,`category`) " +
            "VALUES(#{title},#{time},#{editorName},#{content},#{category});")
    int insertDynamic(Dynamic dynamic);

    @Update("UPDATE t_dynamic SET " +
            "`title` = #{title}, " +
            "`time` = #{time}, " +
            "`editor_name` = #{editorName}, " +
            "`content` = #{content}, " +
            "`category` = #{category} " +
            "WHERE `t_dynamic`.`id`=#{id};")
    int updateDynamic(Dynamic dynamic);

    @Delete("DELETE FROM t_dynamic " +
            "WHERE `t_dynamic`.`id`=#{id};")
    int deleteDynamic(int dynamicId);

    @Insert("INSERT INTO t_teaching_information" +
            "(`numbering`,`name`,`properties`,`teacher_number`,`teaching_time`,`student_level`) " +
            "VALUES (#{numbering},#{name},#{properties},#{teacherNumber},#{teachingTime},#{studentLevel});")
    int insertTeachingInformation(TeachingInformation teachingInformation);

    @Update("UPDATE t_teaching_information SET " +
            "`numbering` = #{numbering}, " +
            "`name` = #{name}, " +
            "`properties` = #{properties}, " +
            "`teacher_number` = #{teacherNumber}, " +
            "`teaching_time` = #{teachingTime}, " +
            "`student_level` = #{studentLevel} " +
            "WHERE `t_teaching_information`.`id` = #{id};")
    int updateTeachingInformation(TeachingInformation teachingInformation);

    @Delete("DELETE FROM t_teaching_information " +
            "WHERE `t_teaching_information`.`id`=#{id};")
    int deleteTeachingInformation(int teachingInformationId);

    @Insert("INSERT INTO t_scientific_information " +
            "(`properties`,`name`,`teacher_number`) " +
            "VALUES (#{properties},#{name},#{teacherNumber});")
    int insertScientificInformation(ScientificInformation scientificInformation);

    @Update("UPDATE t_scientific_information SET " +
            "`properties` = #{properties}, " +
            "`name` = #{name}, " +
            "`teacher_number` = #{teacherNumber} " +
            "WHERE `t_scientific_information`.`id` = #{id};")
    int updateScientificInformation(ScientificInformation scientificInformation);

    @Delete("DELETE FROM t_scientific_information " +
            "WHERE `t_scientific_information`.`id`=#{id}")
    int deleteScientificInformation(int scientificInformationId);

    @Insert("INSERT INTO t_teach_result " +
            "(`name`,`level`,`year`)" +
            "VALUES (#{name},#{level},#{year});")
    int insertTeachResult(TeachResult teachResult);

    @Update("UPDATE t_teach_result SET " +
            "`name` = #{name}, " +
            "`level` = #{level}, " +
            "`year` = #{year} " +
            "WHERE `t_teach_result`.`id` = #{id};")
    int updateTeachResult(TeachResult teachResult);

    @Delete("DELETE FROM t_teach_result " +
            "WHERE `t_teach_result`.`id`=#{id};")
    int deleteTeachResult(int teachResultId);

    @Insert("INSERT INTO t_research_result" +
            "(`name`,`level`,`year`) " +
            "VALUES (#{name},#{level},#{year});")
    int insertResearchResult(ResearchResult researchResult);

    @Update("UPDATE t_research_result SET " +
            "`name` = #{name}, " +
            "`level` = #{level}, " +
            "`year` = #{year} " +
            "WHERE `t_research_result`.`id` = #{id};")
    int updateResearchResult(ResearchResult researchResult);
    @Delete("DELETE FROM t_research_result " +
            "WHERE `t_research_result`.`id`=#{id};")
    int deleteResearchResult(int researchResultId);

    @Insert("INSERT INTO t_teach_paper" +
            "(`title`,`conference`,`conference_id`,`year`) " +
            "VALUES (#{title},#{conference},#{conferenceId},#{year});")
    int insertTeachPaper(TeachPaper teachPaper);

    @Update("UPDATE t_teach_paper SET " +
            "`title` = #{title}, " +
            "`conference` = #{conference}, " +
            "`conference_id` = #{conferenceId}, " +
            "`year` = #{year} " +
            "`WHERE `t_teach_paper`.`id` = #{id};")
    int updateTeachPaper(TeachPaper teachPaper);

    @Delete("DELETE FROM t_teach_paper " +
            "WHERE `t_teach_paper`.`id`=#{id};")
    int deleteTeachPaper(int teachPaperId);







    //何祎君
    //科研论文
    @Insert("INSERT INTO t_research_paper "+
            "(`title`,`conference`,`conference_id`,`year`) "+
            "VALUES(#{title},#{conference},#{conferenceId},#{year});")
    int insertResearchPaper(ResearchPaper researchPaper);

    @Update("UPDATE t_research_paper SET "+
            "`title`=#{title}, "+
            "`conference`=#{conference}, "+
            "`conference_id`=#{conferenceId}, "+
            "`year`=#{year} "+
            "WHERE `id`=#{id};")
    int updateResearchPaper(ResearchPaper researchPaper);

    @Delete("DELETE FROM t_research_paper "+
            "WHERE `id`=#{param1};")
    int deleteResearchPaper(int id);

    //专利
    @Insert("INSERT INTO t_papent "+
            "(`applier`,`papent_name`,`papent_apply_id`) "+
            "VALUES(#{applier},#{papentName},#{papentApplyId});")
    int insertPapent(Papent papent);

    @Update("UPDATE t_papent SET "+
            "`applier`=#{applier}, "+
            "`papent_name`=#{papentName}, "+
            "`papent_apply_id`=#{papentApplyId} "+
            "WHERE `id`=#{id};")
    int updatePapent(Papent papent);

    @Delete("DELETE FROM t_papent "+
            "WHERE `id`=#{param1};")
    int deletePapent(int id);

    //著作权
    @Insert("INSERT INTO t_copy_right "+
            "(`code`,`righter`,`right_name`,`signed_id`) "+
            "VALUES(#{code},#{righter},#{rightName},#{signedId});")
    int insertCopyRight(CopyRight copyRight);

    @Update("UPDATE t_copy_right SET "+
            "`code`=#{code}, "+
            "`righter`=#{righter}, "+
            "`right_name`=#{rightName}, "+
            "`signed_id`=#{signedId} "+
            "WHERE `id`=#{id};")
    int updateCopyRight(CopyRight copyRight);

    @Delete("DELETE FROM t_copy_right "+
            "WHERE `id`=#{param1};")
    int deleteCopyRight(int id);

    //教材
    @Insert("INSERT INTO t_teach_material "+
            "(`name`,`prize_info`,`year`) "+
            "VALUES(#{name},#{prizeInfo},#{year});")
    int insertTeachMaterial(TeachMaterial teachMaterial);

    @Update("UPDATE t_teach_material SET "+
            "`name`=#{name}, "+
            "`prize_info`=#{prizeInfo}, "+
            "`year`=#{year} "+
            "WHERE `id`=#{id};")
    int updateTeachMaterial(TeachMaterial teachMaterial);

    @Delete("DELETE FROM t_teach_material "+
            "WHERE `id`=#{param1};")
    int deleteTeachMaterial(int id);

    //教改
    @Insert("INSERT INTO t_edu_reform "+
            "(`name`,`level`,`year`) "+
            "VALUES(#{name},#{level},#{year});")
    int insertEduReform(EduReform eduReform);

    @Update("UPDATE t_edu_reform SET "+
            "`name`=#{name}, "+
            "`level`=#{level}, "+
            "`year`=#{year} "+
            "WHERE `id`=#{id};")
    int updateEduReform(EduReform eduReform);

    @Delete("DELETE FROM t_edu_reform "+
            "WHERE `id`=#{param1};")
    int deleteEduReform(int id);

    //国际合作
    @Insert("INSERT INTO t_global_cooperation "+
            "(`institution_name`,`country`,`cooperation_projects`) "+
            "VALUES(#{institutionName},#{country},#{cooperationProjects});")
    int insertGlobalCooperation(GlobalCooperation globalCooperation);

    @Update("UPDATE t_global_cooperation SET "+
            "`institution_name`=#{institutionName}, "+
            "`country`=#{country}, "+
            "`cooperation_projects`=#{cooperationProjects} "+
            "WHERE `id`=#{id};")
    int updateGlobalCooperation(GlobalCooperation globalCooperation);

    @Delete("DELETE FROM t_global_cooperation "+
            "WHERE `id`=#{param1};")
    int deleteGlobalCooperation(int id);

    //招生信息
    @Update("UPDATE t_admissions_information SET "+
            "`skills_requirement`=#{skillsRequirement}, "+
            "`operating_hours`=#{operatingHours}, "+
            "`contact`=#{contact}, "+
            "`other`=#{other} "+
            "WHERE `id`=#{id};")
    int updateAdmissionsInformation(AdmissionsInformation admissionsInformation);
}
