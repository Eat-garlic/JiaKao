package com.eglc.jk.common.util;

import com.eglc.jk.common.exception.CommonException;
import com.eglc.jk.pojo.query.PageQuery;
import com.eglc.jk.pojo.result.CodeMsg;
import com.eglc.jk.pojo.result.R;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.stream.Collectors;

public class Rs  {

    public static final String K_COUNT = "count";

    public static R error(Throwable e) {
        if (e instanceof CommonException){
            CommonException ee = (CommonException) e;
           /* R r = new R();
            r.setCode(ee.getCode());
            r.setMsg(ee.getMessage());*/
            return  new R(ee.getCode(),ee.getMessage());
        }else if (e instanceof BindException){
                    //因为  BindException 是属于Throwable类型的
                //如果e 是Bin类型异常，传进来的是一只动物呀，传进来 的是Throwable 这种类型的，如果父类Throwable想要用 子类的
                //的方法 ，就得强制的向下转型，转为子类的类型才可以用子类的方法。 所以

            BindException be = (BindException) e;
            List<ObjectError> errors = be.getBindingResult().getAllErrors();
                //函数式编程 的方式  新特性1.8之后 的 Stream流
            List<String> defaultMsgs = errors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());



        /*.map(e->{
                e.getDefaultMessage();

            }).collect()*/
            


           /* List<String> defaultMsgs = new ArrayList<>(errors.size());
            for (ObjectError error : errors) {
                defaultMsgs.add(error.getDefaultMessage());
            }*/
            String msg = StringUtils.collectionToDelimitedString(defaultMsgs,", ");
            return  error(msg);
        } else {
            //return Rs.error(e.getMessage());
            return Rs.error();
        }

    };




    public static R error (){
     /*   return new R().setSuccess(false);*/
        return new R(false);
    }

    public static R error (String msg) {
      /*  return new R().setSuccess(false).setMsg(msg);*/

        return new R(false,msg);
    }



    /* public static R ok  (DictTypeQuery query){
     *//*  R r = new R();
        r.put(K_COUNT,query.getCount());
        return r.setSuccess(true).setData(query.getData());*//*

       R r =  new R(query.getData());
       r.put(K_COUNT,query.getCount());
       return r;


    }*/



    public static R ok(PageQuery query){
      /*  R r = new R();
        r.put(K_COUNT,query.getCount());
        return r.setSuccess(true).setData(query.getData());*/

        R r =  new R(query.getData());
        r.put(K_COUNT,query.getCount());
        return r;
    }


    /*  public static R ok(ProvinceQuery query){
     *//*  R r = new R();
        r.put(K_COUNT,query.getCount());
        return r.setSuccess(true).setData(query.getData());*//*

        R r =  new R(query.getData());
        r.put(K_COUNT,query.getCount());
        return r;
    }
    public static R ok(CityQuery query){
      *//*  R r = new R();
        r.put(K_COUNT,query.getCount());
        return r.setSuccess(true).setData(query.getData());*//*

        R r =  new R(query.getData());
        r.put(K_COUNT,query.getCount());
        return r;
    }

*/





    public static R ok (String msg) {
     /*   return new R().setSuccess(true).setMsg(msg);*/
        return new R(true,msg);
    }


    public static R ok (Object object) {
     /*   return new R().setSuccess(true).setMsg(msg);*/

        return new R(object);
    }



    public static  R raise(String msg) throws CommonException {
        throw new CommonException(msg);
    }


    public static  R raise(CodeMsg codeMsg) throws CommonException {
        throw new CommonException(codeMsg);
    }

}
