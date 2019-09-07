package com.example.labwebsystem.annex.mapper;

import com.example.labwebsystem.entity.Annex;
import org.apache.ibatis.annotations.*;
import org.springframework.core.annotation.Order;

@Mapper
@Order(1)
public interface AnnexMapper {

    @Insert("INSERT into t_annex "+
            "(`file_name`,`path`,`size`,`dynamic_id`) "+
            "VALUES(#{fileName},#{path},#{size},#{dynamicId});")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")//加入该注解可以保持对象后，查看对象插入id
    int insertAnnex(Annex annex);

    @Select("SELECT `id` as id, " +
            "`file_name` as fileName, " +
            "`path` as path, " +
            "`size` as size, " +
            "`dynamic_id` as dynamicId " +
            "from t_annex " +
            "WHERE id = #{param1} "+
            "LIMIT 1;")
    Annex selectAnnex(int id);

    @Update("UPDATE t_annex SET"+
            "`file_name`=#{fileName}, "+
            "`path`=#{path}, "+
            "`size`=#{size}, "+
            "`dynamic_id`=#{dynamicId} "+
            "WHERE `id`=#{id};")
    int updateAnnex(Annex annex);

    @Update("UPDATE t_annex SET"+
            "`dynamic_id`=#{#param2} "+
            "WHERE `id`=#{#param1};")
    int updateAnnexDynamicId(int id,int dynamicId);

    @Delete("DELETE FROM t_annex "+
            "WHERE `id`=#{param1};")
    int deleteAnnex(int id);

    @Delete("DELETE FROM t_annex "+
            "WHERE `dynamic_id`=#{param1};")
    int deleteAnnexByDynamicId(int dynamic_id);
}
