package com.eglc.jk.pojo.po;
import com.eglc.jk.common.foreign.anno.ForeignCascade;
import com.eglc.jk.common.foreign.anno.ForeignField;
import com.eglc.jk.common.foreign.anno.ForeignTable;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ForeignTable("dict_type")
public class DictType {
    @ForeignField(column = "id",cascade = ForeignCascade.DEFAULT)
    private Integer id;
    @NotBlank(message = "名称不能为空")
    private String name;
    @NotBlank(message = "值不能为空")
    private String value;

    private String intro;
}