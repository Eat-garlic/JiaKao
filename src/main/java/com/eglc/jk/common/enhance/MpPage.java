package com.eglc.jk.common.enhance;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eglc.jk.common.util.Streams;
import com.eglc.jk.pojo.vo.PageVo;
import com.eglc.jk.pojo.vo.req.page.PageReqVo;
import java.util.List;
import java.util.function.Function;



public class MpPage<T> extends Page<T> {
    private final PageReqVo reqVo;
    //传进去的时候需要构建一个Page对象 ，  return baseMapper.selectPage(new MpPage<>(query),wrapper) page对象就是New的这个，所以、
    //这个时候就初始化了 要传入的page和size 然后将这个ReqVo保存到对象 的一个变量中去， 所以 你说这个对象 要不要@Data呢  没有lom怎么getPage呢
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
    public <R> PageVo<R> buildVo (Function<T,R> function){  //接收一个函数式接口的说明d,说明这个要怎么转换

        //查询出来的结果要带到这个PageReqVo 中去， 这个pro 就是返回到前台的对象
  /* ，<before1。（代表迭代之前的代码）
        reqVo.setPage(getCurrent());
        reqVo.setSize(getSize());

        PageVo<R> pageVo = new PageVo<>();
        pageVo.setCount(getTotal());
        pageVo.setPages(getPages());before1。>*/
       return commonBuild(Streams.map(getRecords(), function));  //传入了一个Po对象，通过自己封装的Streams.map方法将list中的po转成vo
                                                                //然后commonBuild接收一个List里面装有Vo的集合



/*
        <before1。数据已经不在 query里面了
        query.setCount(getTotal());
        query.setPages(getPages());
        query.setData(getRecords());before1。>*/
    }



}
