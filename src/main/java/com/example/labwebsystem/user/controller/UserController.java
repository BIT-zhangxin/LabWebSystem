package com.example.labwebsystem.user.controller;

import com.example.labwebsystem.entity.Student;
import com.example.labwebsystem.entity.Teacher;
import com.example.labwebsystem.entity.User;
import com.example.labwebsystem.entity.UserData;
import com.example.labwebsystem.user.mapper.UserMapper;
import com.example.labwebsystem.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;


@RestController
@RequestMapping(value="/user", method = {RequestMethod.POST,RequestMethod.GET})
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    //测试
    @RequestMapping("/test")
    public int test(){
        return 1;
    }

    //创建管理员账号
    @RequestMapping("/insertAdmin")
    public int insertAdmin(){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String password=passwordEncoder.encode("123456");
        return userMapper.insertAdmin(password);
    }

    //登录
    @RequestMapping("/login")
    public User login(String name,String password){
        User user=userMapper.login(name);
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        if(user!=null&&passwordEncoder.matches(password,user.getPassword())){
            user.setPassword(null);
            return user;
        }
        else{
            return null;
        }
    }

    //修改密码
    @RequestMapping("/updatePassword")
    public int updatePassword(int userId,String oldPassword,String newPassword){
        return userService.updatePassword(userId,oldPassword,newPassword);
    }

    //添加一个学生账户
    @RequestMapping("/insertStudent")
    public int insertStudent(Student student){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
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

    //查询在校生
    @RequestMapping("/selectUnderGraduatedStudent")
    public List<Student> selectUnderGraduatedStudent(){
        return userMapper.selectUnderGraduatedStudent();
    }
    
    //查询毕业生
    @RequestMapping("/selectGraduatedStudent")
    public List<Student> selectGraduatedStudent(){
        return userMapper.selectGraduatedStudent();
    }

    //条件查询学生
    @RequestMapping("/selectStudentByCondition")
    public List<Student> selectStudentByCondition(String condition){
        return userMapper.selectStudentByCondition(condition,"%"+condition+"%");
    }

    //添加一个教师账户
    @RequestMapping("/insertTeacher")
    public int insertTeacher(Teacher teacher){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
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
        return userMapper.selectTeacherByCondition(condition,"%"+condition+"%");
    }

    //根据id查询用户（除去管理员的所有用户）
    @RequestMapping("/selectUser")
    public UserData selectUser(int userId){
        return userMapper.selectUser(userId);
    }

    //根据id删除用户（除去管理员的所有用户）
    @RequestMapping("/deleteUser")
    public int deleteUser(int userId){
        return userMapper.deleteUser(userId);
    }

    //查询用户id
    @RequestMapping("/selectUserName")
    public String selectUserName(int userId,int category){
        if(category==1||category==3){
            return userMapper.selectTeacherName(userId);
        }
        else if(category==2){
            return userMapper.selectStudentName(userId);
        }
        else if(category==4){
            return "管理员";
        }
        else{
            return null;
        }

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
