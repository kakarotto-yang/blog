package com.kakarotto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "文章搜索条件")
@Data
public class ArticleQueryVo {

    @ApiModelProperty(value = "帖子标题")
    private String  title;

    @ApiModelProperty(value = "在创建时间之前")
    private String beforeCreateTime;

    @ApiModelProperty(value = "在创建时间之后")
    private String afterCreateTime;

    @ApiModelProperty(value = "在更新时间之前")
    private String beforeUpdateTime;

    @ApiModelProperty(value = "在更新时间之后")
    private String afterUpdateTime;

    @ApiModelProperty(value = "文章类型")
    private int  category;
}
