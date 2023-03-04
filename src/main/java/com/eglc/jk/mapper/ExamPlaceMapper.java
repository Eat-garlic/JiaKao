package com.eglc.jk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eglc.jk.pojo.po.ExamPlace;
import com.eglc.jk.pojo.vo.req.list.ProvinceVo;

import java.util.List;

public interface ExamPlaceMapper  extends BaseMapper<ExamPlace> {
    List<ProvinceVo> selectRegionExamPlaces();
}
