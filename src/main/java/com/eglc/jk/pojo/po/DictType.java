package com.eglc.jk.pojo.po;
import com.eglc.jk.common.foreign.anno.ForeignCascade;
import com.eglc.jk.common.foreign.anno.ForeignField;
import com.eglc.jk.common.foreign.anno.ForeignTable;
import lombok.Data;

@Data
@ForeignTable("dict_type")
public class DictType {
    @ForeignField(column = "id",cascade = ForeignCascade.DEFAULT)
    private Integer id;
    private String name;
    private String value;
    private String intro;
}