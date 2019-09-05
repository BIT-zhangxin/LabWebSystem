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

}
