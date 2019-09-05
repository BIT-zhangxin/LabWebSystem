package com.example.labwebsystem.function.controller;

import com.example.labwebsystem.function.mapper.FunctionMapper;
import com.example.labwebsystem.function.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/function")
public class FunctionController {

    @Autowired
    FunctionService functionService;

    @Autowired
    FunctionMapper functionMapper;

}
