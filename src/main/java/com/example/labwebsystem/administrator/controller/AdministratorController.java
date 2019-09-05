package com.example.labwebsystem.administrator.controller;

import com.example.labwebsystem.administrator.mapper.AdministratorMapper;
import com.example.labwebsystem.administrator.service.AdministratorService;
import com.example.labwebsystem.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

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
    public int insertResearchPaperList(@RequestBody List<ResearchPaper> researchPaperList) {
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
    public int deleteResearchPaperList(@RequestBody List<Integer> researchPaperIdList){
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
    public int insertPapentList(@RequestBody List<Papent> papentList) {
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
    public int deletePapentList(@RequestBody List<Integer> papentIdList){
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
    public int insertCopyRightList(@RequestBody List<CopyRight> copyRightList) {
        try{
            return administratorService.insertCopyRightList(copyRightList);
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
    public int deleteCopyRightList(@RequestBody List<Integer> copyRightIdList){
        try{
            return administratorService.deleteCopyRightList(copyRightIdList);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    //教材
    @RequestMapping("/insertTeachMaterial")
    public int insertTeachMaterial(TeachMaterial teachMaterial){
        return administratorMapper.insertTeachMaterial(teachMaterial);
    }

    @RequestMapping("/insertTeachMaterialList")
    public int insertTeachMaterialList(@RequestBody List<TeachMaterial> teachMaterialList) {
        try{
            return administratorService.insertTeachMaterialList(teachMaterialList);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    @RequestMapping("/updateTeachMaterial")
    public int updateTeachMaterial(TeachMaterial teachMaterial){
        return administratorMapper.updateTeachMaterial(teachMaterial);
    }

    @RequestMapping("/deleteTeachMaterial")
    public int deleteTeachMaterial(int id){
        return administratorMapper.deleteTeachMaterial(id);
    }

    @RequestMapping("/deleteTeachMaterialList")
    public int deleteTeachMaterialList(@RequestBody List<Integer> teachMaterialIdList){
        try{
            return administratorService.deleteTeachMaterialList(teachMaterialIdList);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    //教改
    @RequestMapping("/insertEduReform")
    public int insertEduReform(EduReform eduReform){
        return administratorMapper.insertEduReform(eduReform);
    }

    @RequestMapping("/insertEduReformList")
    public int insertEduReformList(@RequestBody List<EduReform> eduReformList) {
        try{
            return administratorService.insertEduReformList(eduReformList);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    @RequestMapping("/updateEduReform")
    public int updateEduReform(EduReform eduReform){
        return administratorMapper.updateEduReform(eduReform);
    }

    @RequestMapping("/deleteEduReform")
    public int deleteEduReform(int id){
        return administratorMapper.deleteEduReform(id);
    }

    @RequestMapping("/deleteEduReformList")
    public int deleteEduReformList(@RequestBody List<Integer> eduReformIdList){
        try{
            return administratorService.deleteEduReformList(eduReformIdList);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    //国际合作
    @RequestMapping("/insertGlobalCooperation")
    public int insertGlobalCooperation(GlobalCooperation globalCooperation){
        return administratorMapper.insertGlobalCooperation(globalCooperation);
    }

    @RequestMapping("/insertGlobalCooperationList")
    public int insertGlobalCooperationList(@RequestBody List<GlobalCooperation> globalCooperationList) {
        try{
            return administratorService.insertGlobalCooperationList(globalCooperationList);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    @RequestMapping("/updateGlobalCooperation")
    public int updateGlobalCooperation(GlobalCooperation globalCooperation){
        return administratorMapper.updateGlobalCooperation(globalCooperation);
    }

    @RequestMapping("/deleteGlobalCooperation")
    public int deleteGlobalCooperation(int id){
        return administratorMapper.deleteGlobalCooperation(id);
    }

    @RequestMapping("/deleteGlobalCooperationList")
    public int deleteGlobalCooperationList(@RequestBody List<Integer> globalCooperationIdList){
        try{
            return administratorService.deleteGlobalCooperationList(globalCooperationIdList);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    //招生信息
    @RequestMapping("/updateAdmissionsInformation")
    public int updateAdmissionsInformation(AdmissionsInformation admissionsInformation){
        return administratorMapper.updateAdmissionsInformation(admissionsInformation);
    }
}
