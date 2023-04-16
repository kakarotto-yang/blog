package com.kakarotto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel(value = "用户信息搜索条件")
@Data
public class UserQueryVo {

    @ApiModelProperty(value = "用户id列表")
    private List<Integer> id;

    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "用户年龄")
    private Integer age;

    @ApiModelProperty(value = "用户性别")
    private Integer sex;

    @ApiModelProperty(value = "用户学校")
    private String school;

    @ApiModelProperty(value = "班级")
    private String classes;

    @ApiModelProperty(value = "创建时间")
    private String createTimeBegin;

    @ApiModelProperty(value = "创建时间")
    private String createTimeEnd;

    @ApiModelProperty(value = "状态（0：锁定 1：正常）")
    private Integer status;

}
