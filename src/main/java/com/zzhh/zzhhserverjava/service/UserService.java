package com.zzhh.zzhhserverjava.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzhh.zzhhserverjava.dto.UserListPageDTO;
import com.zzhh.zzhhserverjava.entity.User;
import com.zzhh.zzhhserverjava.vo.RegisterUserVo;

import java.util.List;

public interface UserService extends IService<User> {

    User getUserByUsername(String username);

    List<String> listUserRolesByUsername(String username);

    boolean checkLogin(String username,String password);

    IPage<UserListPageDTO> getUserListPage(Page<UserListPageDTO> page, String roleName, String nickname);


    // register user
    boolean registerUser(RegisterUserVo registerUserVo);

    void sendEmail(String email);
}
