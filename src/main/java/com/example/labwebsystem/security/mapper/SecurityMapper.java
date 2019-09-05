package com.example.labwebsystem.security.mapper;

import com.example.labwebsystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.core.annotation.Order;

@Mapper
@Order(1)
public interface SecurityMapper {

    //TODO：待修改
    @Select("select \n" +
            "id as id, \n" +
            "username as username, \n" +
            "name as name, \n" +
            "password as password \n" +
            "from `user` where `user`.`username`=#{param1} limit 1;")
    User getUser(String name);
}
