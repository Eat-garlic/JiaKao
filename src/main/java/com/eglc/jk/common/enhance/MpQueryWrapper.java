package com.eglc.jk.common.enhance;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


public class MpQueryWrapper<T> extends QueryWrapper<T> {

    public MpQueryWrapper<T> like(Object val, String...columns) {
        if (val == null) return this;
        String str = val.toString();
        if (str.length() == 0) return this;
        //这个w就是本身自己 eg:  wrapper.like        w.like  w是类的内部已经定好的类型，什么字母表示已经无关紧要
        return (MpQueryWrapper<T>) nested((w) -> {

            for (String column : columns) {
                w.like(column,str).or();

            }
           /* for (SFunction<T, ?> fun : funcs) {
                //本来

                w.like(fun, str).or();
                // 调用接口中的是这个方法default Children like(R column, Object val)  fun 表示字段
            };*/

        });

    }
}