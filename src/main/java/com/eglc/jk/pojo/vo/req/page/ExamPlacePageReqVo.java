package com.eglc.jk.pojo.vo.req.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ExamPlacePageReqVo extends KeywordPageReqVo {
    @ApiModelProperty("省份id")
    private  Integer provinceId;
    @ApiModelProperty("城市id")
    private  Integer cityId;
}
