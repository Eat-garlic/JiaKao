package com.eglc.jk.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.eglc.jk.common.enhance.MpPage;
import com.eglc.jk.pojo.po.ExamPlaceCourse;
import com.eglc.jk.pojo.vo.req.list.ExamPlaceCourseVo;
import org.apache.ibatis.annotations.Param;

public interface ExamPlaceCourseMapper extends BaseMapper<ExamPlaceCourse> {
            MpPage<ExamPlaceCourseVo> selectPageVos(MpPage<ExamPlaceCourseVo> page,
                                                    @Param(Constants.WRAPPER)Wrapper<ExamPlaceCourseVo> wrapper);

}
