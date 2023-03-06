package com.eglc.jk.common.util;
import com.eglc.jk.common.exception.CommonException;
import com.eglc.jk.pojo.result.CodeMsg;
import com.eglc.jk.pojo.vo.DataJsonVo;
import com.eglc.jk.pojo.vo.JsonVo;
import com.eglc.jk.pojo.vo.PageJsonVo;
import com.eglc.jk.pojo.vo.PageVo;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
生成那三个返回对象的
 */
public class JsonVos {

    public static JsonVo error (String msg) {
        /*  return new R().setSuccess(false).setMsg(msg);*/
        return new JsonVo(false,msg);
    }

    public static JsonVo error (){
        /*   return new R().setSuccess(false);*/
        return new JsonVo(false);
    }

    public static JsonVo error(Throwable e) {
        if (e instanceof CommonException){
            CommonException ee = (CommonException) e;
           /* R r = new R();
            r.setCode(ee.getCode());
            r.setMsg(ee.getMessage());*/
            return  new JsonVo(ee.getCode(),ee.getMessage());
        }else if (e instanceof BindException){
                    //因为  BindException 是属于Throwable类型的
                //如果e 是Bin类型异常，传进来的是一只动物呀，传进来 的是Throwable 这种类型的，(这点很重要，这个e一直是父类类型，特别重要，
                //就像传进来 虽然是一只猫，但是它是属于animl类型的)如果父类Throwable想要用 子类的的方法 ，就得强制的向下转型，转为子类
                // 的类型才可以用子类的方法。 你把e点进去，所以
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
            return error(msg);
        }else if(e instanceof ConstraintViolationException){
            ConstraintViolationException cve = (ConstraintViolationException) e;
            List<String> msgs = cve.getConstraintViolations()
                    .stream().map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());
            String msg  = StringUtils.collectionToDelimitedString(msgs, ", ");
            return error(msg);
        } else {
            //return Rs.error(e.getMessage());
            return JsonVos.error();
        }
    };




    /* before1。public static R ok  (DictTypeQuery query){
     *//*  R r = new R();
        r.put(K_COUNT,query.getCount());
        return r.setSuccess(true).setData(query.getData());*//*

       R r =  new R(query.getData());
       r.put(K_COUNT,query.getCount());
       return r;
    }*/

    /* before1。 public static R ok(ProvinceQuery query){
     *//*  R r = new R();
        r.put(K_COUNT,query.getCount());
        return r.setSuccess(true).setData(query.getData());*//*

        R r =  new R(query.getData());
        r.put(K_COUNT,query.getCount());
        return r;
    }
    before1。public static R ok(CityQuery query){
      *//*  R r = new R();
        r.put(K_COUNT,query.getCount());
        return r.setSuccess(true).setData(query.getData());*//*

        R r =  new R(query.getData());
        r.put(K_COUNT,query.getCount());
        return r;
    }

*/
    public static  JsonVo ok(CodeMsg msg){
        return new JsonVo(msg);
    }

    public  static  <T>  PageJsonVo<T> ok (PageVo<T> pageVo  ){
        PageJsonVo<T> pageJsonVo = new PageJsonVo<>();
        pageJsonVo.setCount (pageVo.getCount());
        pageJsonVo.setData(pageVo.getData());
        return  pageJsonVo;
    }

    public static JsonVo ok (String msg) {
     /*   return new R().setSuccess(true).setMsg(msg);*/
        return new JsonVo(true,msg);
    }

    public static <T> DataJsonVo<T> ok (T data) {
     /*   return new R().setSuccess(true).setMsg(msg);*/
        return new DataJsonVo<>(data);
    }

    public  static  JsonVo ok(){
        return  new JsonVo();
      }

    public static <T> T raise(String msg) throws CommonException {
        throw new CommonException(msg);
    }

    public static  <T> T raise(CodeMsg codeMsg) throws CommonException {
        throw new CommonException(codeMsg);
    }

}
