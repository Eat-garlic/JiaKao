package com.eglc.jk.common.util;

import com.eglc.jk.common.exception.CommonException;
import com.eglc.jk.pojo.query.*;
import com.eglc.jk.pojo.result.R;

public class Rs  {

    public static final String K_COUNT = "count";

    public static R error(Throwable e) {
        if (e instanceof CommonException){
            CommonException ee = (CommonException) e;
           /* R r = new R();
            r.setCode(ee.getCode());
            r.setMsg(ee.getMessage());*/
            return  new R(ee.getCode(),ee.getMessage());
        }else {
            return Rs.error(e.getMessage());
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



    public static R ok (String msg) {
     /*   return new R().setSuccess(true).setMsg(msg);*/
        return new R(true,msg);
    }


    public static R ok (Object object) {
     /*   return new R().setSuccess(true).setMsg(msg);*/

        return new R(object);
    }


    public static R ok  (DictTypeQuery query){
      /*  R r = new R();
        r.put(K_COUNT,query.getCount());
        return r.setSuccess(true).setData(query.getData());*/

       R r =  new R(query.getData());
       r.put(K_COUNT,query.getCount());
       return r;


    }

   

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



}
