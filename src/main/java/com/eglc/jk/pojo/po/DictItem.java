package com.eglc.jk.pojo.po;
import com.eglc.jk.common.foreign.anno.ForeignField;
import com.eglc.jk.common.foreign.anno.ForeignTable;
import com.eglc.jk.common.validator.BoolNumber;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ForeignTable("dict_item")
public class DictItem {

    private Integer id;
    @NotBlank(message = "名称不能为空")
    private String name;
    @NotBlank(message = "disable值不能为空")

    private String value;
    private Integer sn;
    @BoolNumber
    private Short disabled;

    @ForeignField(mainTable = DictType.class, mainField = "id", column = "type_id")
    private Integer typeId;
}