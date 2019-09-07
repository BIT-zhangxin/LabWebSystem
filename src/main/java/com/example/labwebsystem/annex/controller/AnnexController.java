package com.example.labwebsystem.annex.controller;

import com.example.labwebsystem.annex.mapper.AnnexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.labwebsystem.entity.Annex;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/annex")
public class AnnexController {

    @Autowired
    AnnexMapper annexMapper;

    @RequestMapping("/uploadAnnex")
    public int uploadAnnex(MultipartFile uploadFile, HttpServletRequest request) throws IOException {
        //获取文件的原始名
        String filename = uploadFile.getOriginalFilename();
        //根据相对路径获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload")+"/"+getDate();
        //String realPath = "D://upload"+"/"+getDate();
        File file=new File(realPath,filename);
        if(!file.getParentFile().getParentFile().exists())
            file.getParentFile().getParentFile().mkdir();
        if(!file.getParentFile().exists())
            file.getParentFile().mkdir();
        uploadFile.transferTo(file);

        Annex annex=new Annex();
        annex.initAnnex(filename,realPath,Long.toString(file.length()),0);
        annexMapper.insertAnnex(annex);
        return annex.getId();
    }

    @RequestMapping("/downloadAnnex")
    public int downloadAnnex(int id, HttpServletRequest request, HttpServletResponse response)throws Exception{
        Annex annex=annexMapper.selectAnnex(id);
        String filePath=annex.getPath();
        String fileName=annex.getFileName();

        //获取输入流对象（用于读文件）
        FileInputStream fis = new FileInputStream(new File(filePath, fileName));
        //获取后缀名
        String extendFileName = fileName.substring(fileName.lastIndexOf('.'));
        response.setContentType(request.getSession().getServletContext().getMimeType(extendFileName));
        //设置响应头,attachment表示以附件的形式下载，inline表示在线打开
        response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode(fileName,"UTF-8"));
        //获取输出流对象（用于写文件）
        ServletOutputStream os = response.getOutputStream();
        //下载文件,使用spring框架中的FileCopyUtils工具
        FileCopyUtils.copy(fis,os);

        return 1;
    }

    @RequestMapping("/deleteAnnex")
    public int deleteAnnex(int id)throws Exception{
        Annex annex=annexMapper.selectAnnex(id);
        String filePath=annex.getPath();
        String fileName=annex.getFileName();

        File file=new File(filePath, fileName);
        file.delete();
        annexMapper.deleteAnnex(id);

        return 1;
    }

    @RequestMapping("/deleteAnnexByDynamicId")
    public int deleteAnnexByDynamicId(int dynamicId){
        return annexMapper.deleteAnnexByDynamicId(dynamicId);
    }

    @RequestMapping("/updateAnnexDynamicId")
    public int updateAnnexDynamicId(int id,int dynamicId){
        return annexMapper.updateAnnexDynamicId(id,dynamicId);
    }

    //防止同一文件夹文件过多，以日期分文件夹
    private String getDate(){
        Date now=new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String date=dateFormat.format(now);
        return date;
    }
}
