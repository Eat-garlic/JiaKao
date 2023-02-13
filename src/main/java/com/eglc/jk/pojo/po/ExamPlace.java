package com.eglc.jk.pojo.po;

import com.eglc.jk.common.foreign.anno.ForeignCascade;
import com.eglc.jk.common.foreign.anno.ForeignField;
import com.eglc.jk.common.foreign.anno.ForeignTable;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ForeignTable("dict_type")
public class ExamPlace {
    @ForeignField(column = "id",cascade = ForeignCascade.DEFAULT)
    private Integer id;
    private String name;
    private Integer provinceId;
    private Integer cityId;
    private String address;
    private BigDecimal latitude;
    private BigDecimal longitude;

}
