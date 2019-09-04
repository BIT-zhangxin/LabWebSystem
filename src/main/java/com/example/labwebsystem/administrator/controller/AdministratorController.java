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

    //科研论文
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

    //专利
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

    @RequestMapping("/deletePapentList")
    public int deletePapentList(List<Integer> papentIdList){
        try{
            return administratorService.deletePapentList(papentIdList);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    //著作权
    @RequestMapping("/insertCopyRight")
    public int insertCopyRight(CopyRight copyRight){
        return administratorMapper.insertCopyRight(copyRight);
    }

    @RequestMapping("/insertCopyRightList")
    public int insertResearchCopyRightList(List<CopyRight> copyRights) {
        try{
            return administratorService.insertCopyRightList(copyRights);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    @RequestMapping("/updateCopyRight")
    public int updateCopyRight(CopyRight copyRight){
        return administratorMapper.updateCopyRight(copyRight);
    }

    @RequestMapping("/deleteCopyRight")
    public int deleteCopyRight(int id){
        return administratorMapper.deleteCopyRight(id);
    }

    @RequestMapping("/deleteCopyRightList")
    public int deleteCopyRightList(List<Integer> copyRightIdList){
        try{
            return administratorService.deleteCopyRightList(copyRightIdList);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }
}
