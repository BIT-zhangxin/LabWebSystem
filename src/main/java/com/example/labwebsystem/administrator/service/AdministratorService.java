package com.example.labwebsystem.administrator.service;

import com.example.labwebsystem.administrator.mapper.AdministratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {

    @Autowired
    AdministratorMapper administratorMapper;
}
