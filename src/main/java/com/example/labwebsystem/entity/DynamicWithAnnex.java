package com.example.labwebsystem.entity;

import java.util.List;

//修改插入动态的，用postman测试的时候感觉参数只有写成
//{"dynamic":{
//	"title":"title",
//	"editorName":"adsfgag",
//	"content":"content",
//	"category":1
//		},
//"annexPath":["D:\\upload\\20190908103402\\教师信息.xlsx"]
//}
// 才能对应上，对应的要加一个实体
public class DynamicWithAnnex {
    private Dynamic dynamic;
    private List<String> annexPath;

    public Dynamic getDynamic() {
        return dynamic;
    }

    public List<String> getAnnexPath() {
        return annexPath;
    }
}
