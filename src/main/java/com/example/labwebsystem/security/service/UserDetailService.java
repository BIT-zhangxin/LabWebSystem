package com.example.labwebsystem.security.service;

import com.example.labwebsystem.entity.User;
import com.example.labwebsystem.security.entity.UserDetail;
import com.example.labwebsystem.security.mapper.SecurityMapper;
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
    SecurityMapper securityMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = securityMapper.getUser(name);
        if (null == user) {
            throw new UsernameNotFoundException(name);
        }

        UserDetail userDetail=new UserDetail();
        userDetail.setId(user.getId());
        userDetail.setName(user.getName());
        userDetail.setPassword(user.getPassword());
        userDetail.setCategory(user.getCategory());
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        userDetail.setAuthorities(authorities);
        return userDetail;
    }
}
