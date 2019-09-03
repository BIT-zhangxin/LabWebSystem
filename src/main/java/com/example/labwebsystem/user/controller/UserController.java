package com.example.labwebsystem.user.controller;

import com.example.labwebsystem.entity.Student;
import com.example.labwebsystem.user.mapper.UserMapper;
import com.example.labwebsystem.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    //编码器，注册时加密密码用的
    @Autowired
    PasswordEncoder passwordEncoder;

    //增删改查举例
    @RequestMapping("/insertStudent")
    public int insertStudent(Student student){
        return userMapper.insertStudent(student);
    }

    @RequestMapping("/updateStudent")
    public int updateStudent(Student student){
        return userMapper.updateStudent(student);
    }

    @RequestMapping("/updateStudent")
    public List<Student> selectStudent(int currentPage,int pageSize){
        return userMapper.selectStudent(currentPage,pageSize);
    }

    @RequestMapping("/deleteStudent")
    public int deleteStudent(int userId){
        return userMapper.deleteStudent(userId);
    }

    //批量操作举例
    //List<int>会报错，用Integer，一样的
    @RequestMapping("/deleteUsers")
    public int deleteUsers(List<Integer> listUserId) {
        try {
            return userService.deleteUsers(listUserId);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }
}
