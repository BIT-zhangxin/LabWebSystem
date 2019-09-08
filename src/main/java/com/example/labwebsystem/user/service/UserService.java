package com.example.labwebsystem.user.service;

import com.example.labwebsystem.entity.Student;
import com.example.labwebsystem.entity.Teacher;
import com.example.labwebsystem.entity.UserData;
import com.example.labwebsystem.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

//    @Autowired
//    UserMapper userMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public int createUsers(List<UserData> listUserData) throws RuntimeException {
        for(UserData userData:listUserData){
            if(userData.getUserType()==1){
                Teacher teacher=new Teacher(userData);
                String encodePassword=passwordEncoder.encode(teacher.getJobNumber());
                int result=userMapper.insertTeacher(teacher,encodePassword);
                if(result==0){
                    throw new RuntimeException("插入失败");
                }
            }else if(userData.getUserType()==2){
                Student student=new Student(userData);
                String encodePassword=passwordEncoder.encode(student.getStudentNumber());
                int result=userMapper.insertStudent(student,encodePassword);
                if(result==0){
                    throw new RuntimeException("插入失败");
                }
            }else{
                throw new RuntimeException("类型出错");
            }
        }
        return 1;
    }


    @Transactional
    public int deleteUsers(List<Integer> listUserId) throws RuntimeException {
        for (Integer userId : listUserId) {
            int result = userMapper.deleteUser(userId);
            if (result == 0) {
                throw new RuntimeException("删除失败");
            }
        }
        return 1;
    }
}
