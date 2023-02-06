package com.eglc.jk.common.exception;

import com.eglc.jk.common.util.Debugs;
import com.eglc.jk.common.util.Rs;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class CommonExceptionHandle {
    @ExceptionHandler({Throwable.class})
    public void handle(Throwable t,
                                HttpServletRequest request,
                                HttpServletResponse response)throws Exception{

            response.setContentType("application/json; charset=UTF-8");
            response.setStatus(400);

            response.getWriter().write(Rs.error(t).jsonString());


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

        Debugs.fly(t::printStackTrace);

    }



}
