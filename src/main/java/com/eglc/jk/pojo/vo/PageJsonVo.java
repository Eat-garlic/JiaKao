package com.eglc.jk.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("分页结果，不需要总页数的")
public class PageJsonVo<T> extends DataJsonVo<List<T>> {

    @ApiModelProperty("总数")
    //这个Long类型的还是long类型的有待商榷，因为都是对象操作，所以为包装类型
    private Long count;





}



