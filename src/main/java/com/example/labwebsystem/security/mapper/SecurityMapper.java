package com.example.labwebsystem.security.mapper;

import com.example.labwebsystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.core.annotation.Order;

@Mapper
@Order(1)
public interface SecurityMapper {

    @Select("select \n" +
            "`id` as id, \n" +
            "`name` as name, \n" +
            "`password` as password, \n" +
            "`category` as category " +
            "from t_user where `t_user`.`name`=#{param1} limit 1;")
    User getUser(String name);
}
