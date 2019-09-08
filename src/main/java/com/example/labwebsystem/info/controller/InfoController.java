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
    //查询专职或兼职教师
    @RequestMapping("/selectTeacher")
    public List<Teacher> selectTeacher(int category){
        return infoMapper.selectTeacher(category);
    }

    //查询在校生或毕业生
    @RequestMapping("/selectGraduate")
    public List<Student> selectGraduate(){
        return infoMapper.selectGraduate();
    }

    //查询静态内容
    @RequestMapping("/selectStaticContent")
    public StaticContent selectStaticContent(int staticContentId){
        return infoMapper.selectStaticContent(staticContentId);
    }

    //根据类型查询动态
    @RequestMapping("/selectDynamicByType")
    public List<Dynamic> selectDynamicByType(int type){
        return infoMapper.selectDynamicByType(type);
    }

    //根据id查询动态
    @RequestMapping("/selectDynamic")
    public Dynamic selectDynamic(int dynamicId){
        return infoMapper.selectDynamic(dynamicId);
    }

    //类型和条件查询动态
    @RequestMapping("/selectDynamicByCondition")
    public List<Dynamic> selectDynamicByCondition(int type,String condition){
        return infoMapper.selectDynamicByCondition(type,"%"+condition+"%");
    }

    //查询教学信息
    @RequestMapping("/selectTeachingInformation")
    public List<TeachingInformation> selectTeachingInformation(){
        return infoMapper.selectTeachingInformation();
    }

    //条件查询教学信息
    @RequestMapping("/selectTeachingInformationByCondition")
    public List<TeachingInformation> selectTeachingInformationByCondition(String condition){
        return infoMapper.selectTeachingInformationByCondition("%"+condition+"%");
    }

    //查询科研信息
    @RequestMapping("/selectScientificInformation")
    public List<ScientificInformation> selectScientificInformation(){
        return infoMapper.selectScientificInformation();
    }

    //条件查询科研信息
    @RequestMapping("/selectScientificInformationByCondition")
    public List<ScientificInformation> selectScientificInformationByCondition(String condition){
        return infoMapper.selectScientificInformationByCondition("%"+condition+"%");
    }

    //查询教学成果
    @RequestMapping("/selectTeachResult")
    public List<TeachResult> selectTeachResult(){
        return infoMapper.selectTeachResult();
    }

    //条件查询教学成果
    @RequestMapping("/selectTeachResultByCondition")
    public List<TeachResult> selectTeachResultByCondition(String condition){
        return infoMapper.selectTeachResultByCondition("%"+condition+"%");
    }

    //查询科研成果
    @RequestMapping("/selectResearchResult")
    public List<ResearchResult> selectResearchResult(){
        return infoMapper.selectResearchResult();
    }

    //条件查询科研成果
    @RequestMapping("/selectResearchResultByCondition")
    public List<ResearchResult> selectResearchResultByCondition(String condition){
        return infoMapper.selectResearchResultByCondition("%"+condition+"%");
    }

    //查询教学论文
    @RequestMapping("/selectTeachPaper")
    public List<TeachPaper> selectTeachPaper(){
        return infoMapper.selectTeachPaper();
    }

    //条件查询教学论文
    @RequestMapping("/selectTeachPaperByCondition")
    public List<TeachPaper> selectTeachPaperByCondition(String condition){
        return infoMapper.selectTeachPaperByCondition("%"+condition+"%");
    }









    //何祎君
    //查询科研论文
    @RequestMapping("/selectResearchPaper")
    public List<ResearchPaper> selectResearchPaper(){
        return infoMapper.selectResearchPaper();
    }

    //条件查询科研论文
    @RequestMapping("/selectResearchPaperMyCondition")
    public List<ResearchPaper> selectResearchPaperMyCondition(String condition){
        return infoMapper.selectResearchPaperMyCondition("%"+condition+"%");
    }

    //查询专利
    @RequestMapping("/selectPapent")
    public List<Papent> selectPapent(){
        return infoMapper.selectPapent();
    }

    //条件查询专利
    @RequestMapping("/selectPapentMyCondition")
    public List<Papent> selectPapentMyCondition(String condition){
        return infoMapper.selectPapentMyCondition("%"+condition+"%");
    }

    //查询教材
    @RequestMapping("/selectTeachMaterial")
    public List<TeachMaterial> selectTeachMaterial(){
        return infoMapper.selectTeachMaterial();
    }

    //条件查询教材
    @RequestMapping("/selectTeachMaterialMyCondition")
    public List<TeachMaterial> selectTeachMaterialMyCondition(String condition){
        return infoMapper.selectTeachMaterialMyCondition("%"+condition+"%");
    }

    //查询教改
    @RequestMapping("/selectEduReform")
    public List<EduReform> selectEduReform(){
        return infoMapper.selectEduReform();
    }

    //条件查询教改
    @RequestMapping("/selectEduReformMyCondition")
    public List<EduReform> selectEduReformMyCondition(String condition){
        return infoMapper.selectEduReformMyCondition("%"+condition+"%");
    }

    //查询国际合作
    @RequestMapping("/selectGlobalCooperation")
    public List<GlobalCooperation> selectGlobalCooperation(){
        return infoMapper.selectGlobalCooperation();
    }

    //条件查询国际合作
    @RequestMapping("/selectGlobalCooperationMyCondition")
    public List<GlobalCooperation> selectGlobalCooperationMyCondition(String condition){
        return infoMapper.selectGlobalCooperationMyCondition("%"+condition+"%");
    }

    //按类型查询招生信息
    @RequestMapping("/searchAdmissionsInformation")
    public AdmissionsInformation searchAdmissionsInformation(String type){
        return infoMapper.selectAdmissionsInformation(type);
    }

    //id查询附件
    @RequestMapping("/selectAnnex")
    public List<Annex> selectAnnex(int dynamicId){
        return infoMapper.selectAnnex(dynamicId);
    }
}
