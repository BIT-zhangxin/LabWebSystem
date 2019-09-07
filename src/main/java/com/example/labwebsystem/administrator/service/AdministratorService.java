package com.example.labwebsystem.administrator.service;

import com.example.labwebsystem.administrator.mapper.AdministratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.labwebsystem.entity.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdministratorService {

    @Autowired
    AdministratorMapper administratorMapper;

    //潘恋军
    @Transactional
    public int insertTeachingInformations(List<TeachingInformation> listTeachingInformation){
        for(TeachingInformation teachingInformation:listTeachingInformation){
            int result = administratorMapper.insertTeachingInformation(teachingInformation);
            if(result == 0){
                throw new RuntimeException("出错信息");
            }
        }
        return 1;
    }
    @Transactional
    public int deleteTeachingInformations(List<Integer> listTeachingInformationId){
        for(Integer teachingInformationId:listTeachingInformationId){
            int result = administratorMapper.deleteTeachingInformation(teachingInformationId);
            if (result == 0) {
                throw new RuntimeException("出错信息");
            }
        }
        return 1;
    }
    @Transactional
    public int insertScientificInformations(List<ScientificInformation> listScientificInformation){
        for(ScientificInformation scientificInformation:listScientificInformation){
            int result = administratorMapper.insertScientificInformation(scientificInformation);
            if(result == 0){
                throw new RuntimeException("出错信息");
            }
        }
        return 1;
    }
    @Transactional
    public int deleteScientificInformations(List<Integer> listScientificInformationId){
        for(Integer scientificInformationId:listScientificInformationId){
            int result = administratorMapper.deleteScientificInformation(scientificInformationId);
            if (result == 0) {
                throw new RuntimeException("出错信息");
            }
        }
        return 1;
    }
    @Transactional
    public int insertTeachResults(List<TeachResult> listTeachResult){
        for(TeachResult teachResult:listTeachResult){
            int result = administratorMapper.insertTeachResult(teachResult);
            if(result == 0){
                throw new RuntimeException("出错信息");
            }
        }
        return 1;
    }
    @Transactional
    public int deleteTeachResults(List<Integer> listTeachResultId){
        for(Integer teachResultId:listTeachResultId){
            int result = administratorMapper.deleteTeachResult(teachResultId);
            if (result == 0) {
                throw new RuntimeException("出错信息");
            }
        }
        return 1;
    }
    @Transactional
    public int insertResearchResults(List<ResearchResult> listResearchResult){
        for(ResearchResult researchResult:listResearchResult){
            int result = administratorMapper.insertResearchResult(researchResult);
            if(result == 0){
                throw new RuntimeException("出错信息");
            }
        }
        return 1;
    }
    @Transactional
    public int deleteResearchResults(List<Integer> listResearchResultId){
        for(Integer researchResultId:listResearchResultId){
            int result = administratorMapper.deleteResearchResult(researchResultId);
            if (result == 0) {
                throw new RuntimeException("出错信息");
            }
        }
        return 1;
    }
    @Transactional
    public int insertTeachPapers(List<TeachPaper> listTeachPaper){
        for(TeachPaper teachPaper:listTeachPaper){
            int result = administratorMapper.insertTeachPaper(teachPaper);
            if(result == 0){
                throw new RuntimeException("出错信息");
            }
        }
        return 1;
    }
    @Transactional
    public int deleteTeachPapers(List<Integer> listTeachPaperId){
        for(Integer teachPaperId:listTeachPaperId){
            int result = administratorMapper.deleteTeachPaper(teachPaperId);
            if (result == 0) {
                throw new RuntimeException("出错信息");
            }
        }
        return 1;
    }







    //何祎君
    //科研论文
    @Transactional
    public int insertResearchPaperList(List<ResearchPaper> researchPaperList) throws RuntimeException {
        for (ResearchPaper researchPaper : researchPaperList) {

            int result = administratorMapper.insertResearchPaper(researchPaper);
            if (result == 0) {
                throw new RuntimeException("出错信息");
            }
        }
        return 1;
    }

    @Transactional
    public int deleteResearchPaperList(List<Integer> researchPaperIdList) throws RuntimeException{
        for(Integer researchPaperId : researchPaperIdList){
            int result = administratorMapper.deleteResearchPaper(researchPaperId);
            if(result == 0){
                throw  new RuntimeException("出错信息");
            }
        }
        return 1;
    }

    //专利
    @Transactional
    public int insertPapentList(List<Papent> papentList) throws RuntimeException {
        for (Papent papent : papentList) {
            int result = administratorMapper.insertPapent(papent);
            if (result == 0) {
                throw new RuntimeException("出错信息");
            }
        }
        return 1;
    }

    @Transactional
    public int deletePapentList(List<Integer> papentIdList) throws RuntimeException{
        for(Integer papentId : papentIdList){
            int result = administratorMapper.deletePapent(papentId);
            if(result == 0){
                throw  new RuntimeException("出错信息");
            }
        }
        return 1;
    }

    //著作权
    @Transactional
    public int insertCopyRightList(List<CopyRight> copyRightList) throws RuntimeException{
        for (CopyRight copyRight : copyRightList) {
            int result = administratorMapper.insertCopyRight(copyRight);
            if (result == 0) {
                throw new RuntimeException("出错信息");
            }
        }
        return 1;
    }

    @Transactional
    public int deleteCopyRightList(List<Integer> copyRightIdList) throws RuntimeException{
        for(Integer copyRightId : copyRightIdList){
            int result = administratorMapper.deleteCopyRight(copyRightId);
            if(result == 0){
                throw  new RuntimeException("出错信息");
            }
        }
        return 1;
    }

    //教材
    @Transactional
    public int insertTeachMaterialList(List<TeachMaterial> teachMaterialList) throws RuntimeException{
        for (TeachMaterial teachMaterial : teachMaterialList) {
            int result = administratorMapper.insertTeachMaterial(teachMaterial);
            if (result == 0) {
                throw new RuntimeException("出错信息");
            }
        }
        return 1;
    }

    @Transactional
    public int deleteTeachMaterialList(List<Integer> teachMaterialIdList) throws RuntimeException{
        for(Integer teachMaterialId : teachMaterialIdList){
            int result = administratorMapper.deleteTeachMaterial(teachMaterialId);
            if(result == 0){
                throw  new RuntimeException("出错信息");
            }
        }
        return 1;
    }

    //教改
    @Transactional
    public int insertEduReformList(List<EduReform> eduReformList) throws RuntimeException{
        for (EduReform eduReform : eduReformList) {
            int result = administratorMapper.insertEduReform(eduReform);
            if (result == 0) {
                throw new RuntimeException("出错信息");
            }
        }
        return 1;
    }

    @Transactional
    public int deleteEduReformList(List<Integer> eduReformIdList) throws RuntimeException{
        for(Integer eduReformId : eduReformIdList){
            int result = administratorMapper.deleteEduReform(eduReformId);
            if(result == 0){
                throw  new RuntimeException("出错信息");
            }
        }
        return 1;
    }

    //国际合作
    @Transactional
    public int insertGlobalCooperationList(List<GlobalCooperation> globalCooperationList) throws RuntimeException{
        for (GlobalCooperation globalCooperation: globalCooperationList) {
            int result = administratorMapper.insertGlobalCooperation(globalCooperation);
            if (result == 0) {
                throw new RuntimeException("出错信息");
            }
        }
        return 1;
    }

    @Transactional
    public int deleteGlobalCooperationList(List<Integer> globalCooperationIdList) throws RuntimeException{
        for(Integer globalCooperationId : globalCooperationIdList){
            int result = administratorMapper.deleteGlobalCooperation(globalCooperationId);
            if(result == 0){
                throw  new RuntimeException("出错信息");
            }
        }
        return 1;
    }
}
