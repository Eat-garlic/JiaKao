package com.eglc.jk.pojo.po;
import com.eglc.jk.common.foreign.anno.ForeignField;
import lombok.Data;

@Data
public class PlateRegion {
    private Integer id ;
    private String  name;
    private String  plate;
    private String  pinyin;
    @ForeignField(mainTable = PlateRegion.class)
    private String  parentId;
}
