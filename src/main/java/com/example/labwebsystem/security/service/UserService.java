package com.example.labwebsystem.security.service;


import com.example.labwebsystem.security.entity.UserData;
import com.example.labwebsystem.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public boolean register(UserData userData){
        int code=userMapper.register(userData);
        return code == 1;
    }

}
