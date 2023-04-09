package com.zzhh.zzhhserverjava.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author zenghaifeng
 * @Date 2023/4/9 10:38
 * @Package: com.zzhh.zzhhserverjava.util
 * @Class: RedisUtil
 * @Description: TODO
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class RedisUtil {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void saveToRedis(String email,String code){
        redisTemplate.opsForValue().set(email,code,15L, TimeUnit.MINUTES);
    }

    public String getValueFromRedis(String key){
        return redisTemplate.opsForValue().get(key);
    }

}
