package com.eglc.jk.pojo.vo.req.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PageReqVo {
    private  static  final  int DEFAULT_SIZE = 10;
    @ApiModelProperty(value = "页码")
    private long page;
    @ApiModelProperty(value = "每页的大小")
    private long size;

   public long getPage(){
      /* return size<=0 ? 1 : page;*/
       return Math.max(page, 1);
   }

   public long getSize(){
       return size< 1 ? DEFAULT_SIZE : size;
   }

}
