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

    @Update("UPDATE t_papent SET"+
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

    @Update("UPDATE t_copy_right SET"+
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

    @Update("UPDATE t_teach_material SET"+
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

    @Update("UPDATE t_edu_reform SET"+
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

    @Update("UPDATE t_global_cooperation SET"+
            "`institution_name`=#{institutionName}, "+
            "`country`=#{country}, "+
            "`cooperation_projects`=#{cooperationProjects} "+
            "WHERE `id`=#{id};")
    int updateGlobalCooperation(GlobalCooperation globalCooperation);

    @Delete("DELETE FROM t_global_cooperation "+
            "WHERE `id`=#{param1};")
    int deleteGlobalCooperation(int id);

    //招生信息
    @Update("UPDATE t_admissions_information SET"+
            "`skills_requirement`=#{skillsRequirement}, "+
            "`operating_hours`=#{operatingHours}, "+
            "`contact`=#{contact}, "+
            "`other`=#{other} "+
            "WHERE `id`=#{id};")
    int updateAdmissionsInformation(AdmissionsInformation admissionsInformation);
}
