package com.example.labwebsystem.security.controller;

import com.example.labwebsystem.entity.User;
import com.example.labwebsystem.security.entity.UserDetail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

    // Login form
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @RequestMapping("/getUserInfo")
    public User getUserInfo(UserDetail userDetail){
        User user =new User();
        user.setId(userDetail.getId());
        user.setName(userDetail.getName());
        user.setCategory(userDetail.getCategory());
        return user;
    }
}
