package com.zzhh.zzhhserverjava.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzhh.zzhhserverjava.dto.UserListPageDTO;
import com.zzhh.zzhhserverjava.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<String> listUserRolesByUsername(@Param("username") String username);

    IPage<UserListPageDTO> getUserListPage(Page<UserListPageDTO> page, @Param("roleName") String roleName,
                                           @Param("nickname") String nickname);


}
