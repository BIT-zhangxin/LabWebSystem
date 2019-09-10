package com.example.labwebsystem.administrator.controller;

import com.example.labwebsystem.administrator.mapper.AdministratorMapper;
import com.example.labwebsystem.administrator.service.AdministratorService;
import com.example.labwebsystem.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="/administrator", method = {RequestMethod.POST,RequestMethod.GET})
public class AdministratorController {

    @Autowired
    AdministratorService administratorService;

    @Autowired
    AdministratorMapper administratorMapper;

    //静态内容
    @RequestMapping("/updateStaticContent")
    public int updateStaticContent(StaticContent staticContent){
        return administratorMapper.updateStaticContent(staticContent);
    }

    //动态消息（包括照片墙和附件）
    @RequestMapping("/insertDynamic")
    public int insertDynamic(Dynamic dynamic){
        LocalDate localDate = LocalDate.now();
        Timestamp now= Timestamp.valueOf(LocalDateTime.now());
        dynamic.setTime(now);
        return administratorMapper.insertDynamic(dynamic);
    }

    @RequestMapping("/updateDynamic")
    public int updateDynamic(Dynamic dynamic){
        LocalDate localDate = LocalDate.now();
        Timestamp now= Timestamp.valueOf(LocalDateTime.now());
        dynamic.setTime(now);
        return administratorMapper.updateDynamic(dynamic);
    }

    @RequestMapping("/deleteDynamic")
    public int deleteDynamic(int dynamicId){
        return administratorMapper.deleteDynamic(dynamicId);
    }

    //上传文件
    @PostMapping("/importFile")
    public String importFile(MultipartFile file, HttpServletRequest req) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
        String format = sdf.format(new Date());
        String realPath = "D://upload" + format;
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(folder,newName));
        String url = "D://upload" + format+ newName;
        System.out.println(url);
        return url;
    }

    //创建附件
    @RequestMapping("/insertAnnex")
    public int insertAnnex(Annex annex){
        LocalDate localDate = LocalDate.now();
        Timestamp now= Timestamp.valueOf(LocalDateTime.now());
        annex.setTime(now);
        return administratorMapper.insertAnnex(annex);
    }

    @RequestMapping("/updateAnnex")
    public int updateAnnex(Annex annex){
        LocalDate localDate = LocalDate.now();
        Timestamp now= Timestamp.valueOf(LocalDateTime.now());
        annex.setTime(now);
        return administratorMapper.updateAnnex(annex);
    }

    @RequestMapping("/deleteAnnex")
    public int deleteAnnex(int annexId){
        return administratorMapper.deleteAnnex(annexId);
    }

    //教学信息
    @RequestMapping("/insertTeachingInformation")
    public int insertTeachingInformation(TeachingInformation teachingInformation){
        return administratorMapper.insertTeachingInformation(teachingInformation);
    }

    @RequestMapping("/insertTeachingInformations")
    public int insertTeachingInformations(@RequestBody List<TeachingInformation> listTeachingInformation){
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
    public int deleteTeachingInformations(@RequestBody List<Integer> listTeachingInformationId){
        try{
            return administratorService.deleteTeachingInformations(listTeachingInformationId);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    //科研信息
    @RequestMapping("/insertScientificInformation")
    public int insertScientificInformation(ScientificInformation scientificInformation){
        return administratorMapper.insertScientificInformation(scientificInformation);
    }

    @RequestMapping("/insertScientificInformations")
    public int insertScientificInformations(@RequestBody List<ScientificInformation> listScientificInformation){
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
    public int deleteScientificInformations(@RequestBody List<Integer> listScientificInformationId){
        try{
            return administratorService.deleteScientificInformations(listScientificInformationId);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    //教学成果
    @RequestMapping("/insertTeachResult")
    public int insertTeachResult(TeachResult teachResult){
        return administratorMapper.insertTeachResult(teachResult);
    }

    @RequestMapping("/insertTeachResults")
    public int insertTeachResults(@RequestBody List<TeachResult> listTeachResult){
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
    public int deleteTeachResults(@RequestBody List<Integer> listTeachResultId){
        try{
            return administratorService.deleteTeachResults(listTeachResultId);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    //科研成果
    @RequestMapping("/insertResearchResult")
    public int insertResearchResult(ResearchResult researchResult){
        return administratorMapper.insertResearchResult(researchResult);
    }

    @RequestMapping("/insertResearchResults")
    public int insertResearchResults(@RequestBody List<ResearchResult> listResearchResult){
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
    public int deleteResearchResults(@RequestBody List<Integer> listResearchResultId){
        try{
            return administratorService.deleteResearchResults(listResearchResultId);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    //教学论文
    @RequestMapping("/insertTeachPaper")
    public int insertTeachPaper(TeachPaper teachPaper){
        return administratorMapper.insertTeachPaper(teachPaper);
    }

    @RequestMapping("/insertTeachPapers")
    public int insertTeachPapers(@RequestBody List<TeachPaper> listTeachPaper){
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
    public int deleteTeachPapers(@RequestBody List<Integer> listTeachPaperId){
        try{
            return administratorService.deleteTeachPapers(listTeachPaperId);
        }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    //科研论文
    @RequestMapping("/insertResearchPaper")
    public int insertResearchPaper(ResearchPaper researchPaper){
        return administratorMapper.insertResearchPaper(researchPaper);
    }

    @RequestMapping("/insertResearchPapers")
    public int insertResearchPapers(@RequestBody List<ResearchPaper> researchPaperList) {
        try{

            return administratorService.insertResearchPapers(researchPaperList);
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

    @RequestMapping("/deleteResearchPapers")
    public int deleteResearchPapers(@RequestBody List<Integer> researchPaperIdList){
        try{
            return administratorService.deleteResearchPapers(researchPaperIdList);
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

    @RequestMapping("/insertPapents")
    public int insertPapents(@RequestBody List<Papent> papentList) {
        try{
            return administratorService.insertPapents(papentList);
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

    @RequestMapping("/deletePapents")
    public int deletePapents(@RequestBody List<Integer> papentIdList){
        try{
            return administratorService.deletePapents(papentIdList);
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

    @RequestMapping("/insertCopyRights")
    public int insertCopyRights(@RequestBody List<CopyRight> copyRightList) {
        try{
            return administratorService.insertCopyRights(copyRightList);
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

    @RequestMapping("/deleteCopyRights")
    public int deleteCopyRights(@RequestBody List<Integer> copyRightIdList){
        try{
            return administratorService.deleteCopyRights(copyRightIdList);
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

    @RequestMapping("/insertTeachMaterials")
    public int insertTeachMaterials(@RequestBody List<TeachMaterial> teachMaterialList) {
        try{
            return administratorService.insertTeachMaterials(teachMaterialList);
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

    @RequestMapping("/deleteTeachMaterials")
    public int deleteTeachMaterials(@RequestBody List<Integer> teachMaterialIdList){
        try{
            return administratorService.deleteTeachMaterials(teachMaterialIdList);
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

    @RequestMapping("/insertEduReforms")
    public int insertEduReforms(@RequestBody List<EduReform> eduReformList) {
        try{
            return administratorService.insertEduReforms(eduReformList);
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

    @RequestMapping("/deleteEduReforms")
    public int deleteEduReforms(@RequestBody List<Integer> eduReformIdList){
        try{
            return administratorService.deleteEduReforms(eduReformIdList);
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

    @RequestMapping("/insertGlobalCooperations")
    public int insertGlobalCooperations(@RequestBody List<GlobalCooperation> globalCooperationList) {
        try{
            return administratorService.insertGlobalCooperations(globalCooperationList);
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

    @RequestMapping("/deleteGlobalCooperations")
    public int deleteGlobalCooperations(@RequestBody List<Integer> globalCooperationIdList){
        try{
            return administratorService.deleteGlobalCooperations(globalCooperationIdList);
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
