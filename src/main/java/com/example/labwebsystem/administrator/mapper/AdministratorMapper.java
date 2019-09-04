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

    @Insert("INSERT INTO t_research_paper "+
            "(`id`,`title`,`conference`,`conference_id`,`year`) "+
            "VALUES(#{id},#{title},#{conference},#{conferenceId},#{year});")
    int insertResearchPaper(ResearchPaper researchPaper);

    @Update("UPDATE t_research_paper SET "+
            "`title`=#{title}, "+
            "`conference`=#{conference}, "+
            "`conference_id`=#{conferenceId}, "+
            "`year`=#{year}, "+
            "WHERE `id`=#{id};")
    int updateResearchPaper(ResearchPaper researchPaper);

    @Delete("DELETE FROM t_research_paper "+
            "WHERE `id`=#{param1};")
    int deleteResearchPaper(int id);

    @Insert("INSERT INTO t_papent "+
            "(`id`,`applier`,`papent_name`,`papent_apply_id`) "+
            "VALUES(#{id},#{applier},#{papentName},#{papentApplyId});")
    int insertPapent(Papent papent);

    @Update("UPDATE t_papent "+
            "`applier`=#{applier}, "+
            "`papent_name`=#{papent_name}, "+
            "`papent_apply_id`=#{papent_apply_id}, "+
            "WHERE `id`=#{id};")
    int updatePapent(Papent papent);

    @Delete("DELETE FROM t_papent "+
            "WHERE `id`=#{param1};")
    int deletePapent(int id);

    @Insert("INSERT INTO t_copy_right "+
            "(`id`,`code`,`righter`,`right_name`,`signed_id`) "+
            "VALUES(#{id},#{code},#{righter},#{rightName},#{signedId});")
    int insertCopyRight(CopyRight copyRight);

    @Update("UPDATE t_copy_right "+
            "`code`=#{code}, "+
            "`righter`=#{righter}, "+
            "`right_name`=#{rightName}, "+
            "`signed_id`=#{signedId}, "+
            "WHERE `id`=#{id};")
    int updateCopyRight(CopyRight copyRight);

    @Delete("DELETE FROM t_copy_right "+
            "WHERE `id`=#{param1};")
    int deleteCopyRight(int id);
}
