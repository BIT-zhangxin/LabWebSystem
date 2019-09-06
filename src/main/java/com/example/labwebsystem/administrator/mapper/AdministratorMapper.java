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
    @Update("UPDATE t_static_content SET" +
            "`title` = #{title}" +
            "`content` = #{content} " +
            "WHERE `t_static_content`.`id` = #{id}"
    )
    int updateStaticContent(StaticContent staticContent);

    @Insert("INSERT INTO t_dynamic"+
            "(`title`,`time`,`editor_name`,`content`,`category`) VALUES" +
            "(#{title},#{time},#{editorName},#{content},#{category})"
    )
    int insertDynamic(Dynamic dynamic);
    @Update("UPDATE t_dynamic SET" +
            "`title` = #{title}" +
            "`time` = #{time}" +
            "`editor_name` = #{editorName}" +
            "`content` = #{content}" +
            "`category` = #{category}" +
            "WHERE `t_dynamic`.`id`=#{id}"
    )
    int updateDynamic(Dynamic dynamic);
    @Delete("DELETE FROM t_dynamic" +
            "WHERE `t_dynamic`.`id`=#{id}"
    )
    int deleteDynamic(int dynamicId);

    @Insert("INSERT INTO t_teaching_information" +
            "(`numbering`,`name`,`properties`,`teacher_number`,`teaching_time`,`student_level`)" +
            "VALUES (#{numbering},#{name},#{properties},#{teacherNumber},#{teachingTime},#{studentLevel})"
    )
    int insertTeachingInformation(TeachingInformation teachingInformation);
    @Update("UPDATE t_teaching_information SET" +
            "`numbering` = #{numbering}" +
            "`name` = #{name}" +
            "`properties` = #{properties}" +
            "`teacher_number` = #{teacherNumber}" +
            "`teaching_time` = #{teachingTime}" +
            "`student_level` = #{studentLevel}" +
            "WHERE `t_teaching_information`.`id` = #{id}"
    )
    int updateTeachingInformation(TeachingInformation teachingInformation);
    @Delete("DELETE FROM t_teaching_information" +
            "WHERE `t_teaching_information`.`id`=#{id}"
    )
    int deleteTeachingInformation(int teachingInformationId);

    @Insert("INSERT INTO t_scientific_information" +
            "(`properties`,`name`,`teacher_number`)" +
            "VALUES (#{properties},#{name},#{teacherNumber})"
    )
    int insertScientificInformation(ScientificInformation scientificInformation);
    @Update("UPDATE t_scientific_information SET" +
            "`properties` = #{properties}" +
            "`name` = #{name}" +
            "`teacher_number` = #{teacherNumber}" +
            "WHERE `t_scientific_information`.`id` = #{id}"
    )
    int updateScientificInformation(ScientificInformation scientificInformation);
    @Delete("DELETE FROM t_scientific_information" +
            "WHERE `t_scientific_information`.`id`=#{id}"
    )
    int deleteScientificInformation(int scientificInformationId);

    @Insert("INSERT INTO t_teach_result" +
            "(`name`,`level`,`year`)" +
            "VALUES (#{name},#{level},#{year})"
    )
    int insertTeachResult(TeachResult teachResult);
    @Update("UPDATE SET" +
            "`name` = #{name}" +
            "`level` = #{level}" +
            "`year` = #{year}" +
            "WHERE `t_teach_result`.`id` = #{id}"
    )
    int updateTeachResult(TeachResult teachResult);
    @Delete("DELETE FROM t_teach_result" +
            "WHERE `t_teach_result`.`id`=#{id}"
    )
    int deleteTeachResult(int teachResultId);

    @Insert("INSERT INTO t_research_result" +
            "(`name`,`level`,`year`)" +
            "VALUES (#{name},#{level},#{year})"
    )
    int insertResearchResult(ResearchResult researchResult);
    @Update("UPDATE SET" +
            "`name` = #{name}" +
            "`level` = #{level}" +
            "`year` = #{year}" +
            "WHERE `t_research_result`.`id` = #{id}"
    )
    int updateResearchResult(ResearchResult researchResult);
    @Delete("DELETE FROM t_research_result" +
            "WHERE `t_research_result`.`id`=#{id}"
    )
    int deleteResearchResult(int researchResultId);

    @Insert("INSERT INTO t_teach_paper" +
            "(`title`,`conference`,`conference_id`,`year`)" +
            "VALUES (#{title},#{conference},#{conferenceId},#{year})"
    )
    int insertTeachPaper(TeachPaper teachPaper);
    @Update("UPDATE SET" +
            "`title` = #{title}" +
            "`conference` = #{conference}" +
            "`conference_id` = #{conferenceId}" +
            "`year` = #{year}" +
            "`WHERE `t_teach_paper`.`id` = #{id}"
    )
    int updateTeachPaper(TeachPaper teachPaper);
    @Delete("DELETE FROM t_teach_paper" +
            "WHERE `t_teach_paper`.`id`=#{id}"
    )
    int deleteTeachPaper(int teachPaperId);

}
