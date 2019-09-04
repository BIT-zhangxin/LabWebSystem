package com.example.labwebsystem.administrator.service;

import com.example.labwebsystem.administrator.mapper.AdministratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.labwebsystem.entity.*;

import java.util.List;

@Service
public class AdministratorService {

    @Autowired
    AdministratorMapper administratorMapper;

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
}
