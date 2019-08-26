package com.example.labwebsystem.security.service;

import com.example.labwebsystem.security.entity.UserData;
import com.example.labwebsystem.security.entity.UserDetail;
import com.example.labwebsystem.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserData userData = userMapper.getUserData(username);
        if (null == userData) {
            throw new UsernameNotFoundException(username);
        }

        UserDetail userDetail=new UserDetail();
        userDetail.setId(userData.getId());
        userDetail.setUsername(userData.getUsername());
        userDetail.setName(userData.getName());
        userDetail.setPassword(userData.getPassword());
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        userDetail.setAuthorities(authorities);
        return userDetail;
    }
}
