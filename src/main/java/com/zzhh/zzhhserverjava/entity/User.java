package com.zzhh.zzhhserverjava.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@TableName("tb_user")
@ApiModel(value="User Object", description=" user ")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    // user id
    @ApiModelProperty(value = "user table primary key")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    // user name
    @ApiModelProperty(value = " user name ")
    private String username;

    // password
    @ApiModelProperty(value = " password ")
    private String password;

    // nickname
    @ApiModelProperty(" nickname ")
    private String nickname;

    // avatar
    @ApiModelProperty(value = " avatar ")
    private String avatar;

    // intro
    @ApiModelProperty(value = " intro ")
    private String intro;

    // description
    @ApiModelProperty(value = " description ")
    private String description;

    // create time
    @ApiModelProperty(value = " create time ")
    private Date createTime;

    // update time
    @ApiModelProperty(value = " update time ")
    private Date updateTime;

    // is delete
    @ApiModelProperty(value = " 0: enable 1: logic delete ")
    private boolean isDelete;

    // is silence
    @ApiModelProperty(value = " 0: not silence 1: silence ")
    private boolean isSilence;
}
