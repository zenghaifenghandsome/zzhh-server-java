package com.zzhh.zzhhserverjava.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author zenghaifeng
 * @Date 2023/4/9 9:58
 * @Package: com.zzhh.zzhhserverjava.handler
 * @Class: BusinessException
 * @Description: TODO
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends RuntimeException{
    private Integer code;
    private String message;

    public BusinessException(String errMessage){
        this.message=errMessage;
    }
}
