package com.example.labwebsystem.user.controller;

import com.example.labwebsystem.entity.Student;
import com.example.labwebsystem.entity.Teacher;
import com.example.labwebsystem.entity.User;
import com.example.labwebsystem.entity.UserData;
import com.example.labwebsystem.security.entity.UserDetail;
import com.example.labwebsystem.user.mapper.UserMapper;
import com.example.labwebsystem.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.List;


@RestController
@RequestMapping(value="/user", method = {RequestMethod.POST,RequestMethod.GET})
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    //测试
    @RequestMapping("/test")
    public int test(){
        return 1;
    }

    //创建管理员账号
    @RequestMapping("/insertAdmin")
    public int insertAdmin(){
        String password=passwordEncoder.encode("123456");
        return userMapper.insertAdmin(password);
    }

    //获取用户信息（需要登录状态）
    @RequestMapping("/getUserInfo")
    public User getUserInfo(UserDetail userDetail){
        User user =new User();
        user.setId(userDetail.getId());
        user.setName(userDetail.getName());
        user.setCategory(userDetail.getCategory());
        return user;
    }

    //修改密码（需要登录状态），未测试
    @RequestMapping("/updatePassword")
    public int updatePassword(UserDetail userDetail,String oldPassword,String newPassword){
        if(passwordEncoder.matches(oldPassword,userDetail.getPassword())){
            String encodePassword=passwordEncoder.encode(newPassword);
            return userMapper.updatePassword(userDetail.getId(),encodePassword);
        }
        else{
            return -1;
        }
    }

    //添加一个学生账户，已测试
    @RequestMapping("/insertStudent")
    public int insertStudent(Student student){
        String encodePassword=passwordEncoder.encode(student.getStudentNumber());

        SimpleDateFormat stringToDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            student.setAdmissionTime(stringToDateFormat.parse(student.getAdmissionTimeString()));
            student.setGraduationTime(stringToDateFormat.parse(student.getGraduationTimeString()));
            student.setBirthday(stringToDateFormat.parse(student.getBirthdayString()));
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return userMapper.insertStudent(student,encodePassword);
    }

    //更新学生信息
    @RequestMapping("/updateStudent")
    public int updateStudent(Student student){
        SimpleDateFormat stringToDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            student.setAdmissionTime(stringToDateFormat.parse(student.getAdmissionTimeString()));
            student.setGraduationTime(stringToDateFormat.parse(student.getGraduationTimeString()));
            student.setBirthday(stringToDateFormat.parse(student.getBirthdayString()));
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return userMapper.updateStudent(student);
    }

    //查询学生
    @RequestMapping("/selectStudent")
    public List<Student> selectStudent(){
        return userMapper.selectStudent();
    }

    //条件查询学生
    @RequestMapping("/selectStudentByCondition")
    public List<Student> selectStudentByCondition(String condition){
        return userMapper.selectStudentByCondition(condition);
    }

    //添加一个教师账户，已测试
    @RequestMapping("/insertTeacher")
    public int insertTeacher(Teacher teacher){
        String encodePassword=passwordEncoder.encode(teacher.getJobNumber());

        SimpleDateFormat stringToDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            teacher.setBirthday(stringToDateFormat.parse(teacher.getBirthdayString()));
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return userMapper.insertTeacher(teacher,encodePassword);
    }

    //更新教师信息
    @RequestMapping("/updateTeacher")
    public int updateTeacher(Teacher teacher){
        SimpleDateFormat stringToDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            teacher.setBirthday(stringToDateFormat.parse(teacher.getBirthdayString()));
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return userMapper.updateTeacher(teacher);
    }

    //查询教师
    @RequestMapping("/selectTeacher")
    public List<Teacher> selectTeacher(){
        return userMapper.selectTeacher();
    }

    //条件查询教师
    @RequestMapping("/selectTeacherByCondition")
    public List<Teacher> selectTeacherByCondition(String condition){
        return userMapper.selectTeacherByCondition(condition);
    }

    //根据id查询用户（除去管理员的所有用户），已测试
    @RequestMapping("/selectUser")
    public UserData selectUser(int userId){
        return userMapper.selectUser(userId);
    }

    //根据id删除用户（除去管理员的所有用户），已测试
    @RequestMapping("/deleteUser")
    public int deleteUser(int userId){
        return userMapper.deleteUser(userId);
    }

    //批量添加用户
    @RequestMapping("/createUsers")
    public int createUsers(@RequestBody List<UserData> listUserData){
        try {
            return userService.createUsers(listUserData);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    //批量删除用户
    @RequestMapping("/deleteUsers")
    public int deleteUsers(@RequestBody List<Integer> listUserId){
        try {
            return userService.deleteUsers(listUserId);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }
}
