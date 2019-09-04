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

    @Insert("INSERT INTO t_research_paper"+
            "(`id`,`title`,`conference`,`conference_id`,`year`)"+
            "VALUES(#{id},#{title},#{conference},#{conferenceId},#{year});")
    int insertResearchPaper(ResearchPaper researchPaper);

    @Update("UPDATE t_research_paper SET "+
            "`title`=#{title}, "+
            "`conference`=#{conference}, "+
            "`conference_id`=#{conferenceId}, "+
            "`year`=#{year}, "+
            "WHERE `id`=#{id}")
    int updateResearchPaper(ResearchPaper researchPaper);

    @Delete("DELETE FROM t_research_paper "+
            "WHERE `id`=#{param1}")
    int deleteResearchPaper(int id);
}
