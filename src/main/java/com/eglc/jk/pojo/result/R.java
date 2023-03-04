package com.eglc.jk.pojo.result;
import com.eglc.jk.common.enhance.Jsonable;
import java.util.HashMap;
public class R extends HashMap<String, Object>
        implements Jsonable {
    public static final String K_CODE = "code";
    public static final String K_MSG = "msg";
    public static final String K_DATA = "data";
    public static final String K_COUNT = "count";

    public static final int K_SUCCESS = CodeMsg.OPERATE_OK.getCode();
    public static final int K_DEFAULT_ERROR = CodeMsg.BAD_REQUEST.getCode();


    public R(){
        this(true);
    }


    public R(Boolean success){
        this(success, null);
    }


    public R(Boolean success, String msg) {
        //三目运算符用的不熟练
        this(success ? K_SUCCESS : K_DEFAULT_ERROR, msg);
    }


    public R (int code, String msg){
        put(K_CODE, code);
        put(K_MSG , msg);
    }



    public R(CodeMsg  codeMsg){

        this(codeMsg.getCode(),  codeMsg.getMsg());

    }

    public R (String msg, Object data){

        this(data);
        put(K_MSG, msg);
    }

    public  R (Object data){
        put(K_CODE, K_SUCCESS );
        put(K_DATA, data);
    }





/*

   */
/* public   R setSuccess(Boolean success) {
        if (success) {
        return setCode(K_SUCCESS)  ;
        }else {
            return setCode(K_DEFAULT_ERROR).setMsg("操作失败");
        }
    }*//*





    public R setCode(int code) {
            put(K_CODE, code);
        return this;
        }

     public R setMsg(String msg) {
            put(K_MSG, msg  );
         return this;
          }

          public R setData(Object data) {
              put(K_DATA, data);
          return  this ;

          }
*/


        }












