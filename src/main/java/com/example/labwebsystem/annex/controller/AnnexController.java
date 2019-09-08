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

    //上传附件
    @RequestMapping("/uploadAnnex")
    public String uploadAnnex(MultipartFile uploadFile, HttpServletRequest request) throws IOException {
        //获取文件的原始名
        String filename = uploadFile.getOriginalFilename();
        String realPath = request.getSession().getServletContext().getRealPath("/upload")+"/"+getDate();    //根据相对路径获取绝对路径，路径绝对存在
        //String realPath = "C://upload"+"/"+getDate();     //建议测试时使用文件路径确定，实际运行无法确定路径是否存在
        File file=new File(realPath,filename);
        if(!file.getParentFile().getParentFile().exists())
            file.getParentFile().getParentFile().mkdir();
        if(!file.getParentFile().exists())
            file.getParentFile().mkdir();
        uploadFile.transferTo(file);

        return file.getPath();
    }

    //通过附件id下载附件
    @RequestMapping("/downloadAnnex")
    public int downloadAnnex(int id, HttpServletRequest request, HttpServletResponse response)throws Exception{
        Annex annex=annexMapper.selectAnnex(id);
        String filePath=annex.getPath();
        String fileName=annex.getFileName();

        //获取输入流对象（用于读文件）
        FileInputStream fis = new FileInputStream(new File(filePath));
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

    //通过附件路径下载附件
    @RequestMapping("/downloadAnnexByPath")
    public int downloadAnnexByPath(String filePath, HttpServletRequest request, HttpServletResponse response)throws Exception{

        File file=new File(filePath);
        if(!file.exists())
            return 0;

        //获取输入流对象（用于读文件）
        FileInputStream fis = new FileInputStream(file);
        //获取后缀名
        String fileName=filePath.substring(filePath.lastIndexOf('\\'));
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

    //修改动态时可以用这个接口删除附件
    @RequestMapping("/deleteAnnexById")
    public int deleteAnnexById(int id)throws Exception{
        Annex annex=annexMapper.selectAnnex(id);
        String filePath=annex.getPath();

        File file=new File(filePath);
        if(file.exists())
            file.delete();
        annexMapper.deleteAnnex(id);

        return 1;
    }

    //在文件上传后，动态未发表前，使用这个接口删除已上传的文件
    @RequestMapping("/deleteAnnexByPath")
    public int deleteAnnexByByPath(String filePath)throws Exception{
        File file=new File(filePath);
        if(file.exists())
            file.delete();
        return 1;
    }

    //修改动态时，可以用这个接口上传增加新附件
    @RequestMapping("/insertAnnex")
    public int insertAnnexList(String filePath,int dynamicId){
        Annex annex=new Annex();
        String fileName=filePath.substring(filePath.lastIndexOf('\\'));
        annex.initAnnex(fileName,filePath,dynamicId);
        return annexMapper.insertAnnex(annex);
    }

    //防止同一文件夹文件过多，以日期分文件夹
    private String getDate(){
        Date now=new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String date=dateFormat.format(now);
        return date;
    }
}
