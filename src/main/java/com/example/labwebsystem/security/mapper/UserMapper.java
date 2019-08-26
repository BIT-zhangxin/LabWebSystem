package com.example.labwebsystem.security.mapper;

import com.example.labwebsystem.security.entity.UserData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.core.annotation.Order;

@Mapper
@Order(1)
public interface UserMapper {

    @Select("select \n" +
            "id as id, \n" +
            "username as username, \n" +
            "name as name, \n" +
            "password as password \n" +
            "from `user` where `user`.`username`=#{param1} limit 1;")
    UserData getUserData(String username);

    @Insert("insert into user \n" +
            "(username,name,password) \n" +
            "values(#{username},#{name},#{password})")
    Integer register(UserData userData);


    @Select("select \n" +
            "id as id, \n" +
            "username as username, \n" +
            "name as name, \n" +
            "password as password, \n" +
            "college_id as collegeId, \n" +
            "status as status \n" +
    "from `user` limit 1")
    UserData test();
}
