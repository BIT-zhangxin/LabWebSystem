package com.example.labwebsystem.info.service;

import com.example.labwebsystem.info.mapper.InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    @Autowired
    InfoMapper infoMapper;
}
