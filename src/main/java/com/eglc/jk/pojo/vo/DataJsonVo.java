package com.eglc.jk.pojo.vo;

import lombok.Data;

@Data
public class DataJsonVo<T> extends JsonVo{
    private T data;
    public  DataJsonVo() {
    };


    public DataJsonVo(String msg, T data){
        super(true, msg);
        this.data = data;
}


    public  DataJsonVo (T data){
        this(null, data);
    }

}
