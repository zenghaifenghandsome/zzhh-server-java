package com.zzhh.zzhhserverjava.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserListPageDTO {
    // user id
    @ApiModelProperty(value = "user id")
    @TableId(value = "user_id",type = IdType.AUTO)
    private Integer userId;

    // description
    @ApiModelProperty(value = "description")
    private String description;

    // nickname
    @ApiModelProperty(value = "nickname")
    private String nickname;

    // avatar
    @ApiModelProperty(value = "avatar")
    private String avatar;

    // create time
    @ApiModelProperty(value = "create time")
    private Date createTime;

    // update time
    @ApiModelProperty(value = "update time")
    private Date updateTime;

    // is silence
    @ApiModelProperty(value = "is silence")
    private Boolean isSilence;
}
