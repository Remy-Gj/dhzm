package com.dhzm.util;


//图片工具辅助类
public class ImageHelper {

    //自动加上图片域名
    public  static  String GetImger(Object imgurl){
        if(imgurl == null)return  "";
        if(imgurl.toString() == "")return "";
        String imgurlstr = imgurl.toString();

        if(imgurlstr.startsWith("https://") || imgurlstr.startsWith("http://")) {
            return  imgurlstr;
        }

        return  String.format("http://localhost:8080/" + imgurlstr);
        }
    }

