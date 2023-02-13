package com.eglc.jk.pojo.query;

import lombok.Data;

@Data
public class ExamPlaceQuery extends KeywordQuery{
    private Integer provinceId;
    private Integer cityId;
}
