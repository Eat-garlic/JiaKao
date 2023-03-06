package com.eglc.jk.common.util;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Streams {
    public static <T, R> List<R> map(Collection<T> list, Function<T, R> function) {
      //list 流的新特性;  通过Stream流中的一个map方法(此方法接收function接口) 可以将一个集合中的类型转换为类型
        // list.stream().map(function)，转出来的类型要换为字符串的collect(Collectors.toList())
        //返回出去的就是list里面装着被转换的类型
        return list.stream().map(function).collect(Collectors.toList());

    }
}
