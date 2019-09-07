package com.example.labwebsystem.info.controller;

import com.example.labwebsystem.info.mapper.InfoMapper;
import com.example.labwebsystem.info.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.labwebsystem.entity.*;

import java.util.List;

@RestController
@RequestMapping(value="/info", method = {RequestMethod.POST,RequestMethod.GET})
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
    public List<Dynamic> selectDynamicByType(int type){
        return infoMapper.selectDynamicByType(type);
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
    public List<TeachingInformation> selectTeachingInformation(){
        return infoMapper.selectTeachingInformation();
    }
    @RequestMapping("/selectTeachingInformationByCondition")
    public List<TeachingInformation> selectTeachingInformationByCondition(String condition){
        return infoMapper.selectTeachingInformationByCondition(condition);
    }

    //对t_scientific_information表格操作
    @RequestMapping("/selectScientificInformation")
    public List<ScientificInformation> selectScientificInformation(){
        return infoMapper.selectScientificInformation();
    }
    @RequestMapping("/selectScientificInformationByCondition")
    public List<ScientificInformation> selectScientificInformationByCondition(String condition){
        return infoMapper.selectScientificInformationByCondition(condition);
    }

    //对t_teach_result表格操作
    @RequestMapping("/selectTeachResult")
    public List<TeachResult> selectTeachResult(){
        return infoMapper.selectTeachResult();
    }
    @RequestMapping("/selectTeachResultByCondition")
    public List<TeachResult> selectTeachResultByCondition(String condition){
        return infoMapper.selectTeachResultByCondition(condition);
    }

    //对t_research_result表格操作
    @RequestMapping("/selectResearchResult")
    public List<ResearchResult> selectResearchResult(){
        return infoMapper.selectResearchResult();
    }
    @RequestMapping("/selectResearchResultByCondition")
    public List<ResearchResult> selectResearchResultByCondition(String condition){
        return infoMapper.selectResearchResultByCondition(condition);
    }

    //对t_teach_paper表格操作
    @RequestMapping("/selectTeachPaper")
    public List<TeachPaper> selectTeachPaper(){
        return infoMapper.selectTeachPaper();
    }
    @RequestMapping("/selectTeachPaperByCondition")
    public List<TeachPaper> selectTeachPaperByCondition(String condition){
        return infoMapper.selectTeachPaperByCondition(condition);
    }









    //何祎君
    //科研论文
    @RequestMapping("/selectResearchPaper")
    public List<ResearchPaper> selectResearchPaper(){
        return infoMapper.selectResearchPaper();
    }

    @RequestMapping("/selectResearchPaperMyCondition")
    public List<ResearchPaper> selectResearchPaperMyCondition(String condition){
        return infoMapper.selectResearchPaperMyCondition(condition);
    }

    //专利
    @RequestMapping("/selectPapent")
    public List<Papent> selectPapent(){
        return infoMapper.selectPapent();
    }

    @RequestMapping("/selectPapentMyCondition")
    public List<Papent> selectPapentMyCondition(String condition){
        return infoMapper.selectPapentMyCondition(condition);
    }

    //教材
    @RequestMapping("/selectTeachMaterial")
    public List<TeachMaterial> selectTeachMaterial(){
        return infoMapper.selectTeachMaterial();
    }

    @RequestMapping("/selectTeachMaterialMyCondition")
    public List<TeachMaterial> selectTeachMaterialMyCondition(String condition){
        return infoMapper.selectTeachMaterialMyCondition(condition);
    }

    //教改
    @RequestMapping("/selectEduReform")
    public List<EduReform> selectEduReform(){
        return infoMapper.selectEduReform();
    }

    @RequestMapping("/selectEduReformMyCondition")
    public List<EduReform> selectEduReformMyCondition(String condition){
        return infoMapper.selectEduReformMyCondition(condition);
    }

    //国际合作
    @RequestMapping("/selectGlobalCooperation")
    public List<GlobalCooperation> selectGlobalCooperation(){
        return infoMapper.selectGlobalCooperation();
    }

    @RequestMapping("/selectGlobalCooperationMyCondition")
    public List<GlobalCooperation> selectGlobalCooperationMyCondition(String condition){
        return infoMapper.selectGlobalCooperationMyCondition(condition);
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
