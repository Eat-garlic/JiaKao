package com.eglc.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eglc.jk.pojo.po.ExamPlaceCourse;
import com.eglc.jk.pojo.vo.PageVo;
import com.eglc.jk.pojo.vo.req.list.ExamPlaceCourseVo;
import com.eglc.jk.pojo.vo.req.page.ExamPlaceCoursePageReqVo;

public interface ExamPlaceCourseService  extends IService<ExamPlaceCourse> {

    PageVo<ExamPlaceCourseVo> list(ExamPlaceCoursePageReqVo query);
}
