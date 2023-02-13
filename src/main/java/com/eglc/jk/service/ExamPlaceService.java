package com.eglc.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eglc.jk.pojo.po.ExamPlace;
import com.eglc.jk.pojo.query.ExamPlaceQuery;

public interface ExamPlaceService extends IService<ExamPlace> {
    void list(ExamPlaceQuery query);
}
