package com.example.labwebsystem.administrator.controller;

import com.example.labwebsystem.administrator.mapper.AdministratorMapper;
import com.example.labwebsystem.administrator.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.labwebsystem.entity.*;

import java.util.List;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @Autowired
    AdministratorService administratorService;

    @Autowired
    AdministratorMapper administratorMapper;

    @RequestMapping("/updateStaticContent")
    public int updateStaticContent(StaticContent staticContent){
        return administratorMapper.updateStaticContent(staticContent);
    }

    @RequestMapping("/insertDynamic")
    public int insertDynamic(Dynamic dynamic){
        return administratorMapper.insertDynamic(dynamic);
    }
    @RequestMapping("/updateDynamic")
    public int updateDynamic(Dynamic dynamic){
        return administratorMapper.updateDynamic(dynamic);
    }
    @RequestMapping("/deleteDynamic")
    public int deleteDynamic(int dynamicId){
        return administratorMapper.deleteDynamic(dynamicId);
    }

    @RequestMapping("/insertTeachingInformation")
    public int insertTeachingInformation(TeachingInformation teachingInformation){
        return administratorMapper.insertTeachingInformation(teachingInformation);
    }
    @RequestMapping("/insertTeachingInformations")
    public int insertTeachingInformations(List<TeachingInformation> listTeachingInformation){
        try {
            return administratorService.insertTeachingInformations(listTeachingInformation);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }
    @RequestMapping("/updateTeachingInformation")
    public int updateTeachingInformation(TeachingInformation teachingInformation){
        return administratorMapper.updateTeachingInformation(teachingInformation);
    }
    @RequestMapping("/deleteTeachingInformation")
    public int deleteTeachingInformation(int teachingInformationId){
        return administratorMapper.deleteTeachingInformation(teachingInformationId);
    }
    @RequestMapping("/deleteTeachingInformations")
    public int deleteTeachingInformations(List<Integer> listTeachingInformationId){
        try{
            return administratorService.deleteTeachingInformations(listTeachingInformationId);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    @RequestMapping("/insertScientificInformation")
    public int insertScientificInformation(ScientificInformation scientificInformation){
        return administratorMapper.insertScientificInformation(scientificInformation);
    }
    @RequestMapping("/insertScientificInformations")
    public int insertScientificInformations(List<ScientificInformation> listScientificInformation){
        try{
            return administratorService.insertScientificInformations(listScientificInformation);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }
    @RequestMapping("/updateScientificInformation")
    public int updateScientificInformation(ScientificInformation scientificInformation){
        return administratorMapper.updateScientificInformation(scientificInformation);
    }
    @RequestMapping("/deleteScientificInformation")
    public int deleteScientificInformation(int scientificInformationId){
        return administratorMapper.deleteScientificInformation(scientificInformationId);
    }
    @RequestMapping("/deleteScientificInformations")
    public int deleteScientificInformations(List<Integer> listScientificInformationId){
        try{
            return administratorService.deleteScientificInformations(listScientificInformationId);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    @RequestMapping("/insertTeachResult")
    public int insertTeachResult(TeachResult teachResult){
        return administratorMapper.insertTeachResult(teachResult);
    }
    @RequestMapping("/insertTeachResults")
    public int insertTeachResults(List<TeachResult> listTeachResult){
        try{
            return administratorService.insertTeachResults(listTeachResult);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }
    @RequestMapping("/updateTeachResult")
    public int updateTeachResult(TeachResult teachResult){
        return administratorMapper.updateTeachResult(teachResult);
    }
    @RequestMapping("/deleteTeachResult")
    public int deleteTeachResult(int teachResultId){
        return administratorMapper.deleteTeachResult(teachResultId);
    }
    @RequestMapping("/deleteTeachResults")
    public int deleteTeachResults(List<Integer> listTeachResultId){
        try{
            return administratorService.deleteTeachResults(listTeachResultId);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    @RequestMapping("/insertResearchResult")
    public int insertResearchResult(ResearchResult researchResult){
        return administratorMapper.insertResearchResult(researchResult);
    }
    @RequestMapping("/insertResearchResults")
    public int insertResearchResults(List<ResearchResult> listResearchResult){
        try{
            return administratorService.insertResearchResults(listResearchResult);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }
    @RequestMapping("/updateResearchResult")
    public int updateResearchResult(ResearchResult researchResult){
        return administratorMapper.updateResearchResult(researchResult);
    }
    @RequestMapping("/deleteResearchResult")
    public int deleteResearchResult(int researchResultId){
        return administratorMapper.deleteResearchResult(researchResultId);
    }
    @RequestMapping("/deleteResearchResults")
    public int deleteResearchResults(List<Integer> listResearchResultId){
        try{
            return administratorService.deleteResearchResults(listResearchResultId);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    @RequestMapping("/insertTeachPaper")
    public int insertTeachPaper(TeachPaper teachPaper){
        return administratorMapper.insertTeachPaper(teachPaper);
    }
    @RequestMapping("/insertTeachPapers")
    public int insertTeachPapers(List<TeachPaper> listTeachPaper){
        try{
            return administratorService.insertTeachPapers(listTeachPaper);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }
    @RequestMapping("/updateTeachPaper")
    public int updateTeachPaper(TeachPaper teachPaper){
        return administratorMapper.updateTeachPaper(teachPaper);
    }
    @RequestMapping("/deleteTeachPaper")
    public int deleteTeachPaper(int teachPaperId){
        return  administratorMapper.deleteTeachPaper(teachPaperId);
    }
    @RequestMapping("/deleteTeachPapers")
    public int deleteTeachPapers(List<Integer> listTeachPaperId){
        try{
            return administratorService.deleteTeachPapers(listTeachPaperId);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }
}
