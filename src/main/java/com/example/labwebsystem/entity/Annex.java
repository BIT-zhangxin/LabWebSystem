package com.example.labwebsystem.entity;

import lombok.Data;

@Data
public class Annex {
    private Integer id;//附件id
    private String fileName;//文件名称
    private String path;//文件路径
    private Integer dynamicId;//对应动态id


    public void initAnnex(String fileName,String path,int dynamicId){
        this.id=0;
        this.fileName=fileName;
        this.path=path;
        this.dynamicId=dynamicId;
    }

    public int getId(){
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getPath() {
        return path;
    }
}
