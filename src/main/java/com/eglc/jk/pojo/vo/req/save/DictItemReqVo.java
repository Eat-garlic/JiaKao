package com.eglc.jk.pojo.vo.req.save;

import com.eglc.jk.common.validator.BoolNumber;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class DictItemReqVo {
    @ApiModelProperty("id,【大于0代表更新，否则代表添加 ")
    private Integer id;

    @NotBlank(message = "名称不能为空")
    @ApiModelProperty(value = "名称【不能为空】",required = true)
    private String name;

    @NotBlank(message = "值不能为空")
    @ApiModelProperty(value = "值【不能为空】",required = true)
    private String value;

    @Min(value = 0 , message = "序号不能是负数")
    @ApiModelProperty("序号【不能是负数，值越大，就排在越前面，默认0】")
    private Integer sn;

    @BoolNumber(message = "disable只能是0和1")
    @ApiModelProperty("是否禁用，【0代表不禁用(启用)，1代表禁用，默认为 0】 ")
    private Short disabled;

    @NotBlank
    @ApiModelProperty(value = "数据字典类型id",required = true)
    private Integer typeId;
}