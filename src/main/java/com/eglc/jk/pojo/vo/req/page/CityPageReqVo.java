package com.eglc.jk.pojo.vo.req.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CityPageReqVo extends KeywordPageReqVo {
    @ApiModelProperty("省份id")
    private Integer parentId;
}
