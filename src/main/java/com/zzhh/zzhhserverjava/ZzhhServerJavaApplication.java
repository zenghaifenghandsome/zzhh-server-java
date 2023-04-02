package com.zzhh.zzhhserverjava;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zzhh.zzhhserverjava.mapper")
public class ZzhhServerJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZzhhServerJavaApplication.class, args);
    }

}
