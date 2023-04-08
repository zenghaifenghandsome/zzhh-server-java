package com.zzhh.zzhhserverjava.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzhh.zzhhserverjava.dto.UserListPageDTO;
import com.zzhh.zzhhserverjava.entity.User;
import com.zzhh.zzhhserverjava.mapper.UserMapper;
import com.zzhh.zzhhserverjava.service.UserService;
import com.zzhh.zzhhserverjava.vo.RegisterUserVo;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableScheduling
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    //@Autowired
    //private BCryptPasswordEncoder bCryptPasswordEncoder;
    //@Autowired
    //private JavaMailSender javaMailSender;
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
        // get code from redis




        return false;
    }

    @Override
    public void sendEmail(String email) {

    }
}
