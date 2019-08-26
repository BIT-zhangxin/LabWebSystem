package com.example.labwebsystem.security.controller;

import com.example.labwebsystem.security.entity.UserData;
import com.example.labwebsystem.security.entity.UserDetail;
import com.example.labwebsystem.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public boolean register(UserData userData){
        String password = passwordEncoder.encode(userData.getPassword());
        userData.setPassword(password);
        return userService.register(userData);
    }

    @RequestMapping("/getUserInfo")
    public UserData getUserInfo(UserDetail userDetail){
        UserData userData=new UserData();
        userData.setId(userDetail.getId());
        userData.setUsername(userDetail.getUsername());
        userData.setName(userDetail.getName());
        return userData;
    }
}
