package com.eglc.jk.common.enhance;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;


public class MpQueryWrapper<T> extends LambdaQueryWrapper<T> {

    public MpQueryWrapper<T> like(Object val, SFunction<T, ?>... funcs) {
        if (val == null) return this;
        String str = val.toString();
        if (str.length() == 0) return this;
        return (MpQueryWrapper<T>) nested((w) -> {
            for (SFunction<T, ?> fun : funcs) {
                w.like(fun, str).or();
            }
            ;
        });

    }
}