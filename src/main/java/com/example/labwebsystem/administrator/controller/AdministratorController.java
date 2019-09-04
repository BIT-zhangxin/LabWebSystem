package com.example.labwebsystem.administrator.controller;

import com.example.labwebsystem.administrator.mapper.AdministratorMapper;
import com.example.labwebsystem.administrator.service.AdministratorService;
import com.example.labwebsystem.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @Autowired
    AdministratorService administratorService;

    @Autowired
    AdministratorMapper administratorMapper;

    @RequestMapping("/insertResearchPaper")
    public int insertResearchPaper(ResearchPaper researchPaper){
        return administratorMapper.insertResearchPaper(researchPaper);
    }

    @RequestMapping("/insertResearchPaperList")
    public int insertResearchPaperList(List<ResearchPaper> researchPaperList) {
        try{
            return administratorService.insertResearchPaperList(researchPaperList);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    @RequestMapping("/updateResearchPaper")
    public int updateResearchPaper(ResearchPaper researchPaper){
        return administratorMapper.updateResearchPaper(researchPaper);
    }

    @RequestMapping("/deleteResearchPaper")
    public int deleteResearchPaper(int id) {
        return administratorMapper.deleteResearchPaper(id);
    }

    @RequestMapping("/deleteResearchPaperList")
    public int deleteResearchPaperList(List<Integer> researchPaperIdList){
        try{
            return administratorService.deleteResearchPaperList(researchPaperIdList);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    @RequestMapping("/insertPapent")
    public int insertPapent(Papent papent){
        return administratorMapper.insertPapent(papent);
    }

    @RequestMapping("/insertPapentList")
    public int insertResearchPapentList(List<Papent> papentList) {
        try{
            return administratorService.insertPapentList(papentList);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    @RequestMapping("/updatePapent")
    public int updatePapent(Papent papent){
        return administratorMapper.updatePapent(papent);
    }

    @RequestMapping("/deletePapent")
    public int deletePapent(int id){
        return administratorMapper.deletePapent(id);
    }


}
