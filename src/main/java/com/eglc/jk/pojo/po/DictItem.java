package com.eglc.jk.pojo.po;
import lombok.Data;
@Data
public class DictItem {
    private Integer id;
    private String name;
    private String value;
    private Integer sn;
    private Short disabled;
    private Integer typeId;
}