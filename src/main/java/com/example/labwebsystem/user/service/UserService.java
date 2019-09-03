package com.example.labwebsystem.user.service;

import com.example.labwebsystem.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    @Transactional
    public int deleteUsers(List<Integer> listUserId) throws RuntimeException {
        for (Integer userId : listUserId) {
            int result = userMapper.deleteStudent(userId);
            if (result == 0) {
                throw new RuntimeException("出错信息");
            }
        }
        return 1;
    }
}
