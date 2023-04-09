package com.zzhh.zzhhserverjava;

import com.zzhh.zzhhserverjava.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Random;

/**
 * @Author zenghaifeng
 * @Date 2023/4/9 12:55
 * @Package: com.zzhh.zzhhserverjava
 * @Class: Email
 * @Description: TODO
 * @Version 1.0
 */
@SpringBootTest
public class Email {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private RedisUtil redisUtil;
    @Test
    public void sendEmail() {
        String email = "zenghaifenghandsome@gmail.com";
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            code.append(random.nextInt(10));
        }

        // send code
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("zenghaifenghandsom@163.com");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("code");
        simpleMailMessage.setText("您的验证码为：" + code.toString() + " 有效期15分钟，请不要告诉他人哦！");
        javaMailSender.send(simpleMailMessage);

        // save code and email to redis
        redisUtil.saveToRedis(email, code.toString());
    }
}
