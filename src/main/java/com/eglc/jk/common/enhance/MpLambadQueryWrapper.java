package com.eglc.jk.common.enhance;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;


public class MpLambadQueryWrapper<T> extends LambdaQueryWrapper<T> {

    public MpLambadQueryWrapper<T> like(Object val, SFunction<T, ?>... funcs) {
        if (val == null) return this;
        String str = val.toString();
        if (str.length() == 0) return this;
        //这个w就是本身自己 eg:  wrapper.like        w.like  w是类的内部已经定好的类型，什么字母表示已经无关紧要
        return (MpLambadQueryWrapper<T>) nested((w) -> {
            for (SFunction<T, ?> fun : funcs) {
                //本来

                w.like(fun, str).or();
                // 调用接口中的是这个方法default Children like(R column, Object val)  fun 表示字段
            };

        });

    }
}