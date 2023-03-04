package com.eglc.jk.pojo.po;
import com.eglc.jk.common.foreign.anno.ForeignField;
import com.eglc.jk.common.foreign.anno.ForeignTable;
import lombok.Data;

@Data
@ForeignTable("dict_item")
public class DictItem {

    private Integer id;
    private String name;
    private String value;
    private Integer sn;
    private Short disabled;

    @ForeignField(mainTable = DictType.class, mainField = "id", column = "type_id")
    private Integer typeId;
}