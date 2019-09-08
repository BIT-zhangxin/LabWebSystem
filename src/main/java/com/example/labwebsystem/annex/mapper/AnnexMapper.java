package com.example.labwebsystem.annex.mapper;

import com.example.labwebsystem.entity.Annex;
import org.apache.ibatis.annotations.*;
import org.springframework.core.annotation.Order;

@Mapper
@Order(1)
public interface AnnexMapper {

    @Select("SELECT `id` as id, " +
            "`file_name` as fileName, " +
            "`path` as path, " +
            "`size` as size, " +
            "`dynamic_id` as dynamicId " +
            "from t_annex " +
            "WHERE id = #{param1} "+
            "LIMIT 1;")
    Annex selectAnnex(int id);

    @Insert("INSERT into t_annex "+
            "(`file_name`,`path`,`dynamic_id`) "+
            "VALUES(#{fileName},#{path},#{dynamicId});")
    int insertAnnex(Annex annex);

    @Delete("DELETE FROM t_annex "+
            "WHERE `id`=#{param1};")
    int deleteAnnex(int id);
}
