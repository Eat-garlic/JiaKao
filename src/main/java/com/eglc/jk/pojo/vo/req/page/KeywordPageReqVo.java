package com.eglc.jk.pojo.vo.req.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class KeywordPageReqVo extends PageReqVo {
    @ApiModelProperty(value = "搜索关键词")
    private String keyword;


}
