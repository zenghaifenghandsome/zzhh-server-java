package com.zzhh.zzhhserverjava.util;

public enum ResultInfo implements IResult{
    SUCCESS(200,"success"),
    ERROR(400,"error"),
    NOT_FOUND(404,"not found"),
    UPDATE_ERROR(678,"update fail"),
    UPDATE_SUCCESS(679,"update success"),
    NO_DATA_FOUND(999,"not found any data"),
    LOGIN_SUCCESS(123,"login success"),
    LOGIN_FAIL(1232,"login fail"),
    VERIFY_SUCCESS(756,"login verify success"),
    VERIFY_FAIL(885,"login verify fail"),
    ;

    private final Integer code;
    private final String message;

    ResultInfo(Integer code,String message){
        this.code = code;
        this.message = message;
    }


    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
