package com.example.labwebsystem.function.service;

import com.example.labwebsystem.function.mapper.FunctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FunctionService {

    @Autowired
    FunctionMapper functionMapper;
}
