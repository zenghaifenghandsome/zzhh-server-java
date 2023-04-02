package com.zzhh.zzhhserverjava.util;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class Result implements Serializable {
    private boolean success;
    private Integer code;
    private String message;
    private Map<String,Object> data = new HashMap<>();

    private Result(){}

    public static Result ok(){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultInfo.SUCCESS.getCode());
        result.setMessage(ResultInfo.SUCCESS.getMessage());
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(ResultInfo.ERROR.getCode());
        result.setMessage(ResultInfo.ERROR.getMessage());
        return result;
    }

    public Result success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public Result code(Integer code){
        this.setCode(code);
        return this;
    }

    public Result message(String message){
        this.setMessage(message);
        return this;
    }

    public Result data(String key,Object data){
        this.data.put(key, data);
        return this;
    }
}
