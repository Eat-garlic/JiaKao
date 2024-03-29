package com.eglc.jk.pojo.vo.req.list;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("区域")
public class PlateRegionVo {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("车牌")
    private String plate;

    @ApiModelProperty("父区域id")
    private Integer parentId;
}