package com.dhzm.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

//统一返回结果的类
@Data
public class Ri {


    @ApiModelProperty(value = "返回码")
    private Integer error;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();


    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    //把构造方法私有
    private Ri() {}

    //成功静态方法
    public static Ri ok() {
        Ri ri = new Ri();
        ri.setError(ResultCode.SUCCESS);
        ri.setMessage("成功");
        return ri;
    }

    //失败静态方法
    public static Ri error() {
        Ri ri = new Ri();
        ri.setError(ResultCode.ERROR);
        ri.setMessage("失败");
        return ri;
    }


    public Ri message(String message){
        this.setMessage(message);
        return this;
    }

    public Ri error(Integer error){
        this.setError(error);
        return this;
    }

    public Ri data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public Ri data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

    public Ri(Integer error, String message, Map<String, Object> data) {
        this.error = error;
        this.message = message;
        this.data = data;
    }


    public Ri( Integer error, String message) {
        this.error = error;
        this.message = message;
    }
}
