package com.example.labwebsystem.info.controller;

import com.example.labwebsystem.entity.*;
import com.example.labwebsystem.info.mapper.InfoMapper;
import com.example.labwebsystem.info.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    InfoService infoService;

    @Autowired
    InfoMapper infoMapper;

    //科研论文
    @RequestMapping("/selectResearchPaper")
    List<ResearchPaper> selectResearchPaper(int currentPage,int pageSize){
        return infoMapper.selectResearchPaper((currentPage-1)*pageSize,pageSize);
    }

    @RequestMapping("/searchResearchPaper")
    List<ResearchPaper> searchResearchPaper(String condition,int currentPage,int pageSize){
        condition="%"+condition+"%";
        return infoMapper.searchResearchPaper(condition,(currentPage-1)*pageSize,pageSize);
    }

    //专利
    @RequestMapping("/selectPapent")
    List<Papent> selectPapent(int currentPage,int pageSize){
        return infoMapper.selectPapent((currentPage-1)*pageSize,pageSize);
    }

    @RequestMapping("/searchPapent")
    List<Papent> searchPapent(String condition,int currentPage,int pageSize){
        condition="%"+condition+"%";
        return infoMapper.searchPapent(condition,(currentPage-1)*pageSize,pageSize);
    }

    //教材
    @RequestMapping("/selectTeachMaterial")
    List<TeachMaterial> selectTeachMaterial(int currentPage,int pageSize){
        return infoMapper.selectTeachMaterial((currentPage-1)*pageSize,pageSize);
    }

    @RequestMapping("/searchTeachMaterial")
    List<TeachMaterial> searchTeachMaterial(String condition,int currentPage,int pageSize){
        condition="%"+condition+"%";
        return infoMapper.searchTeachMaterial(condition,(currentPage-1)*pageSize,pageSize);
    }

    //教改
    @RequestMapping("/selectEduReform")
    List<EduReform> selectEduReform(int currentPage,int pageSize){
        return infoMapper.selectEduReform((currentPage-1)*pageSize,pageSize);
    }

    @RequestMapping("/searchEduReform")
    List<EduReform> searchEduReform(String condition,int currentPage,int pageSize){
        condition="%"+condition+"%";
        return infoMapper.searchEduReform(condition,(currentPage-1)*pageSize,pageSize);
    }

    //国际合作
    @RequestMapping("/selectGlobalCooperation")
    List<GlobalCooperation> selectGlobalCooperation(int currentPage,int pageSize){
        return infoMapper.selectGlobalCooperation((currentPage-1)*pageSize,pageSize);
    }

    @RequestMapping("/searchGlobalCooperation")
    List<GlobalCooperation> searchGlobalCooperation(String condition,int currentPage,int pageSize){
        condition="%"+condition+"%";
        return infoMapper.searchGlobalCooperation(condition,(currentPage-1)*pageSize,pageSize);
    }

    //招生信息
    @RequestMapping("/searchAdmissionsInformation")
    AdmissionsInformation searchAdmissionsInformation(String type){
        return infoMapper.selectAdmissionsInformation(type);
    }
}
