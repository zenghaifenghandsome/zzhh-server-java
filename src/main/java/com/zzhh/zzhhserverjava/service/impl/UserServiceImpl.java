package com.zzhh.zzhhserverjava.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzhh.zzhhserverjava.dto.UserListPageDTO;
import com.zzhh.zzhhserverjava.entity.User;
import com.zzhh.zzhhserverjava.handler.BusinessException;
import com.zzhh.zzhhserverjava.mapper.UserMapper;
import com.zzhh.zzhhserverjava.service.UserService;
import com.zzhh.zzhhserverjava.util.RedisUtil;
import com.zzhh.zzhhserverjava.vo.RegisterUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@EnableScheduling
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    //@Autowired
    //private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public User getUserByUsername(String username) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username",username);
        User user = this.baseMapper.selectOne(userQueryWrapper);
        return user;
    }

    @Override
    public List<String> listUserRolesByUsername(String username) {
        return null;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        return false;
    }

    @Override
    public IPage<UserListPageDTO> getUserListPage(Page<UserListPageDTO> page, String roleName, String nickname) {
        return this.baseMapper.getUserListPage(page,roleName,nickname);
    }

    @Override
    public boolean registerUser(RegisterUserVo registerUserVo) {
        User user = new User();

        // get email
        String email = registerUserVo.getEmail();
        // get code from redis
        String redisValue = redisUtil.getValueFromRedis(email);
        if (redisValue.equals(registerUserVo.getCode())){
            user.setUsername(registerUserVo.getUsername());
            user.setPassword();
        }


        return false;
    }

    /**
     * @Author: zenghaifeng
     * @Date: 2023/4/9 9:49
     * @TODO: send email code
     *
     * @param: email
     *             user register email
     *
     */
    @Override
    public void sendCode(String email) {
        if(!checkEmail(email)){
            throw new BusinessException("email format is error!");
        }
        // general code 6 bit
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0;i<6;i++){
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
        redisUtil.saveToRedis(email,code.toString());
    }

    /**
     * @Author: zenghaifeng
     * @Date: 2023/4/9 9:54
     * @TODO: TODO
     *
     * @param: email
     *
     * @return: boolean
     *
     */
    private boolean checkEmail(String email) {
        String RULE_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";

        // compile regex
        Pattern compile = Pattern.compile(RULE_EMAIL);
        // matcher
        Matcher matcher = compile.matcher(email);
        // run matches
        return matcher.matches();
    }
}
