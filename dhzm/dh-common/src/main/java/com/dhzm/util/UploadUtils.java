package com.dhzm.util;


import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UploadUtils {
     //定义一个目标路径，吧图片上传到的位置
    private static final String BASE_PATH="D:\\picture\\bendi";

    //定义访问路径的地址
    private static final String SERVER_PATH="/bendi/";

    public static String upload(MultipartFile imgFile){
        System.out.println(imgFile);
        //获得上传文件的名字
        String imgFiles = imgFile.getOriginalFilename();
        //为了保证图片在服务器中名字的唯一性，这个是我们要用UUID对名字进行改写,
        String uuid= UUID.randomUUID().toString().replace("-","");
        //将生成的uuid和filename进行拼接
        String newFilename = uuid + "-" + imgFiles;
        //创建一个文件实例对象
        File image = new File(BASE_PATH,newFilename);
        //对文件进行上传的操作

        try {
            imgFile.transferTo(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return SERVER_PATH + newFilename;
    }
//    public static String upload(MultipartFile file){
//        //获得上传文件的名字
//        String filename = file.getOriginalFilename();
//        //为了保证图片在服务器中名字的唯一性，这个是我们要用UUID对名字进行改写,
//        String uuid= UUID.randomUUID().toString().replace("-","");
//        //将生成的uuid和filename进行拼接
//        String newFilename = uuid + "-" + filename;
//        //创建一个文件实例对象
//        File image = new File(newFilename);
//        //对文件进行上传的操作
//        try {
//            file.transferTo(image);
//        } catch (IOException e) {
//            return null;
//        }
//        return newFilename;
//    }
}
