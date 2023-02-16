package com.eglc.jk.common.exception;

import com.eglc.jk.common.util.Debugs;
import com.eglc.jk.common.util.Rs;
import com.eglc.jk.pojo.result.R;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class CommonExceptionHandle {
    @ExceptionHandler({Throwable.class})
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public R handle(Throwable t,
                    HttpServletRequest request,
                    HttpServletResponse response)throws Exception{


        Debugs.fly(t::printStackTrace);
        return Rs.error(t);

       /*正常写
        Debugs.fly(new Runnable() {
            @Override
            public void run() {
                t.printStackTrace();
            }
        });*/


           /*    lambda表达式
            Debugs.fly(()->{    没写参数时需要写括号
                t.printStackTrace();
            });
        */

          /*  lambda表达式的简化：方法引用
           Debugs.fly(t::printStackTrace);  引用特定对象的实例方法 ObjectName::instanceMethodName

        */


    }
    }




