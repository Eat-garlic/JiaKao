package com.eglc.jk.common.enhance;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eglc.jk.common.util.Streams;
import com.eglc.jk.pojo.vo.PageVo;
import com.eglc.jk.pojo.vo.req.page.PageReqVo;

import java.util.List;
import java.util.function.Function;

public class MpPage<T> extends Page<T> {
    private final PageReqVo reqVo;

    public MpPage (PageReqVo reqVo){
        //传入前台输入的页数  到这里，然后利用 my-p来查询
        super(reqVo.getPage(), reqVo.getSize());
        this.reqVo = reqVo;
    }


    public <N> PageVo<N>  commonBuild(List<N> data){
        reqVo.setPage(getCurrent());
        reqVo.setSize(getSize());

        PageVo<N> pageVo = new PageVo<>();

        pageVo.setCount(getTotal());
        pageVo.setPages(getPages());
        pageVo.setData(data);
        return  pageVo ;
    }




    public PageVo<T>  buildVo () {
        //查询出来的结果要带到这个PageReqVo 中去， 这个pro 就是返回到前台的对象

            return commonBuild(getRecords());
    }





    //把mybatisplus中的查询出来的po转为PageVo
    public <R> PageVo<R> buildVo (Function<T,R> function){

        //查询出来的结果要带到这个PageReqVo 中去， 这个pro 就是返回到前台的对象
  /*      reqVo.setPage(getCurrent());
        reqVo.setSize(getSize());


        PageVo<R> pageVo = new PageVo<>();
        pageVo.setCount(getTotal());
        pageVo.setPages(getPages());*/


       return commonBuild(Streams.map(getRecords(), function));

/*             数据已经不在 query里面了
        query.setCount(getTotal());
        query.setPages(getPages());
        query.setData(getRecords());*/
    }





}
