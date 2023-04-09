package com.zzhh.zzhhserverjava.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzhh.zzhhserverjava.dto.UserListPageDTO;
import com.zzhh.zzhhserverjava.service.UserService;
import com.zzhh.zzhhserverjava.util.Result;
import com.zzhh.zzhhserverjava.util.ResultInfo;
import com.zzhh.zzhhserverjava.vo.RegisterUserVo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = " user model")
public class UserController {

    private UserService userService;

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET )
    public Result getUserList(@RequestParam(value = "current",required = true,defaultValue = "1") Integer current,
                              @RequestParam(value = "size",required = true,defaultValue = "5") Integer size,
                              @RequestParam(value = "roleName",required = false) String roleName,
                              @RequestParam(value = "nickname",required = false) String nickname){

        Page<UserListPageDTO> page = new Page<>(current,size);
        IPage<UserListPageDTO> userListPage = userService.getUserListPage(page, roleName, nickname);
        long total = userListPage.getTotal();
        List<UserListPageDTO> data = userListPage.getRecords();

        if (total>0){
            return Result.ok().data("data",data).data("total",total);
        }else {
            return Result.error().code(ResultInfo.NO_DATA_FOUND.getCode())
                    .message(ResultInfo.NO_DATA_FOUND.getMessage());
        }
    }


    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public Result registerUser(@RequestBody RegisterUserVo registerUserVo){
        userService.registerUser(registerUserVo);
        return null;
    }


}
