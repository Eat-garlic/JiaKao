package com.eglc.jk.pojo.query;

import lombok.Data;

import java.util.List;

@Data
public class PageQuery {
    private  static  final  int DEFAULT_SIZE = 10;
    private Long page;
    private Long size;

    /**
     * 当前 这一页的数据
     */
   private List<?> data;

    /**
     * 总数
     */
   private Long count;

    /**
     * 总页数
     */
   private Long pages;


   public long getPage(){

      /* return size<=0 ? 1 : page;*/
       return Math.max(page, 1);

   }


   public long getSize(){
       return size< 1 ? DEFAULT_SIZE : size;
   }



}
