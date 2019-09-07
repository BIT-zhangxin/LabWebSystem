package com.example.labwebsystem.info.controller;

import com.example.labwebsystem.info.mapper.InfoMapper;
import com.example.labwebsystem.info.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.labwebsystem.entity.*;

import java.util.List;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    InfoService infoService;

    @Autowired
    InfoMapper infoMapper;

    //潘恋军
    //对t_teacher表格操作
    @RequestMapping("/selectTeacher")
    public  List<Teacher> selectTeacher(int category){
        return infoMapper.selectTeacher(category);
    }

    //对t_student表格进行操作
    @RequestMapping("/selectGraduate")
    public  List<Student> selectGraduate(){
        return infoMapper.selectGraduate();
    }

    //对t_static_content表格进行操作
    @RequestMapping("/selectStaticContent")
    public StaticContent selectStaticContent(int staticContentId){
        return infoMapper.selectStaticContent(staticContentId);
    }

    //对t_dynamic表格操作
    @RequestMapping("/selectDynamicByType")
    public List<Dynamic> selectDynamicByType(int type,int currentPage,int pageSize){
        int offset = (currentPage -1 ) * pageSize;
        return infoMapper.selectDynamicByType(type,offset,pageSize);
    }
    @RequestMapping("/selectDynamic")
    public Dynamic selectDynamic(int dynamicId){
        return infoMapper.selectDynamic(dynamicId);
    }
    @RequestMapping("/selectDynamicByCondition")
    public List<Dynamic> selectDynamicByCondition(int type,String condition){
        return infoMapper.selectDynamicByCondition(type,condition);
    }

    //对t_teaching_information表格操作
    @RequestMapping("/selectTeachingInformation")
    public List<TeachingInformation> selectTeachingInformation(int currentPage,int pageSize){
        int offset = (currentPage -1 ) * pageSize;
        return infoMapper.selectTeachingInformation(offset,pageSize);
    }
    @RequestMapping("/selectTeachingInformationByCondition")
    public List<TeachingInformation> selectTeachingInformationByCondition(String condition){
        return infoMapper.selectTeachingInformationByCondition(condition);
    }

    //对t_scientific_information表格操作
    @RequestMapping("/selectScientificInformation")
    public List<ScientificInformation> selectScientificInformation(int currentPage,int pageSize){
        int offset = (currentPage -1 ) * pageSize;
        return infoMapper.selectScientificInformation(offset,pageSize);
    }
    @RequestMapping("/selectScientificInformationByCondition")
    public List<ScientificInformation> selectScientificInformationByCondition(String condition){
        return infoMapper.selectScientificInformationByCondition(condition);
    }

    //对t_teach_result表格操作
    @RequestMapping("/selectTeachResult")
    public List<TeachResult> selectTeachResult(int currentPage,int pageSize){
        int offset = (currentPage -1 ) * pageSize;
        return infoMapper.selectTeachResult(offset,pageSize);
    }
    @RequestMapping("/selectTeachResultByCondition")
    public List<TeachResult> selectTeachResultByCondition(String condition){
        return infoMapper.selectTeachResultByCondition(condition);
    }

    //对t_research_result表格操作
    @RequestMapping("/selectResearchResult")
    public List<ResearchResult> selectResearchResult(int currentPage,int pageSize){
        int offset = (currentPage -1 ) * pageSize;
        return infoMapper.selectResearchResult(offset,pageSize);
    }
    @RequestMapping("/selectResearchResultByCondition")
    public List<ResearchResult> selectResearchResultByCondition(String condition){
        return infoMapper.selectResearchResultByCondition(condition);
    }

    //对t_teach_paper表格操作
    @RequestMapping("/selectTeachPaper")
    public List<TeachPaper> selectTeachPaper(int currentPage,int pageSize){
        int offset = (currentPage -1 ) * pageSize;
        return infoMapper.selectTeachPaper(offset,pageSize);
    }
    @RequestMapping("/selectTeachPaperByCondition")
    public List<TeachPaper> selectTeachPaperByCondition(String condition){
        return infoMapper.selectTeachPaperByCondition(condition);
    }









    //何祎君
    //科研论文
    @RequestMapping("/selectResearchPaper")
    public List<ResearchPaper> selectResearchPaper(int currentPage,int pageSize){
        return infoMapper.selectResearchPaper((currentPage-1)*pageSize,pageSize);
    }

    @RequestMapping("/selectResearchPaperMyCondition")
    public List<ResearchPaper> selectResearchPaperMyCondition(String condition,int currentPage,int pageSize){
        condition="%"+condition+"%";
        return infoMapper.selectResearchPaperMyCondition(condition,(currentPage-1)*pageSize,pageSize);
    }

    //专利
    @RequestMapping("/selectPapent")
    public List<Papent> selectPapent(int currentPage,int pageSize){
        return infoMapper.selectPapent((currentPage-1)*pageSize,pageSize);
    }

    @RequestMapping("/selectPapentMyCondition")
    public List<Papent> selectPapentMyCondition(String condition,int currentPage,int pageSize){
        condition="%"+condition+"%";
        return infoMapper.selectPapentMyCondition(condition,(currentPage-1)*pageSize,pageSize);
    }

    //教材
    @RequestMapping("/selectTeachMaterial")
    public List<TeachMaterial> selectTeachMaterial(int currentPage,int pageSize){
        return infoMapper.selectTeachMaterial((currentPage-1)*pageSize,pageSize);
    }

    @RequestMapping("/selectTeachMaterialMyCondition")
    public List<TeachMaterial> selectTeachMaterialMyCondition(String condition,int currentPage,int pageSize){
        condition="%"+condition+"%";
        return infoMapper.selectTeachMaterialMyCondition(condition,(currentPage-1)*pageSize,pageSize);
    }

    //教改
    @RequestMapping("/selectEduReform")
    public List<EduReform> selectEduReform(int currentPage,int pageSize){
        return infoMapper.selectEduReform((currentPage-1)*pageSize,pageSize);
    }

    @RequestMapping("/selectEduReformMyCondition")
    public List<EduReform> selectEduReformMyCondition(String condition,int currentPage,int pageSize){
        condition="%"+condition+"%";
        return infoMapper.selectEduReformMyCondition(condition,(currentPage-1)*pageSize,pageSize);
    }

    //国际合作
    @RequestMapping("/selectGlobalCooperation")
    public List<GlobalCooperation> selectGlobalCooperation(int currentPage,int pageSize){
        return infoMapper.selectGlobalCooperation((currentPage-1)*pageSize,pageSize);
    }

    @RequestMapping("/selectGlobalCooperationMyCondition")
    public List<GlobalCooperation> selectGlobalCooperationMyCondition(String condition,int currentPage,int pageSize){
        condition="%"+condition+"%";
        return infoMapper.selectGlobalCooperationMyCondition(condition,(currentPage-1)*pageSize,pageSize);
    }

    //招生信息
    @RequestMapping("/searchAdmissionsInformation")
    public AdmissionsInformation searchAdmissionsInformation(String type){
        return infoMapper.selectAdmissionsInformation(type);
    }

    //附件
    @RequestMapping("/selectAnnex")
    public List<Annex> selectAnnex(int dynamicId){
        return infoMapper.selectAnnex(dynamicId);
    }
}
