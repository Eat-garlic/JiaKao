package com.eglc.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eglc.jk.pojo.po.ExamPlace;
import com.eglc.jk.pojo.vo.PageVo;
import com.eglc.jk.pojo.vo.req.list.ExamPlaceVo;
import com.eglc.jk.pojo.vo.req.list.ProvinceVo;
import com.eglc.jk.pojo.vo.req.page.ExamPlacePageReqVo;

import java.util.List;

public interface ExamPlaceService extends IService<ExamPlace> {
    PageVo<ExamPlaceVo> list(ExamPlacePageReqVo query);


    List<ProvinceVo> listRegionExamPlaces();
}
