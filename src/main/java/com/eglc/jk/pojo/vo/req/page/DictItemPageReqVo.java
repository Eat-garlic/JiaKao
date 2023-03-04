package com.eglc.jk.pojo.vo.req.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DictItemPageReqVo extends KeywordPageReqVo {
    @ApiModelProperty("数据字典类型id")
    private Integer typeId;
}
