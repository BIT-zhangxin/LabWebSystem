package com.example.labwebsystem.function.service;

import com.example.labwebsystem.entity.UserGrouping;
import com.example.labwebsystem.function.mapper.FunctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FunctionService {

    @Autowired
    FunctionMapper functionMapper;


    @Transactional
    public int addGroupingUsers(List<UserGrouping> listUserGrouping) throws RuntimeException {
        for(UserGrouping userGrouping:listUserGrouping){
            int result = functionMapper.addGroupingUser(userGrouping);
            if (result == 0) {
                throw new RuntimeException("添加失败");
            }
        }
        return 1;
    }


    @Transactional
    public int deleteGroupingUsers(List<UserGrouping> listUserGrouping) throws RuntimeException {
        for (UserGrouping userGrouping : listUserGrouping) {
            int result = functionMapper.deleteGroupingUser(userGrouping);
            if (result == 0) {
                throw new RuntimeException("删除失败");
            }
        }
        return 1;
    }
}
