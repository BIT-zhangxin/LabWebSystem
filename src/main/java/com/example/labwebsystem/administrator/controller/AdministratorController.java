package com.example.labwebsystem.administrator.controller;

import com.example.labwebsystem.administrator.mapper.AdministratorMapper;
import com.example.labwebsystem.administrator.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @Autowired
    AdministratorService administratorService;

    @Autowired
    AdministratorMapper administratorMapper;

}
