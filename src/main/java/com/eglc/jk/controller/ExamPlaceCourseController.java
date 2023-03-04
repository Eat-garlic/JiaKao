package com.eglc.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eglc.jk.common.mapStruct.MapStructs;
import com.eglc.jk.common.util.JsonVos;
import com.eglc.jk.pojo.po.ExamPlaceCourse;
import com.eglc.jk.pojo.vo.PageJsonVo;
import com.eglc.jk.pojo.vo.req.list.ExamPlaceCourseVo;
import com.eglc.jk.pojo.vo.req.page.ExamPlaceCoursePageReqVo;
import com.eglc.jk.pojo.vo.req.save.ExamPlaceCourseReqVo;
import com.eglc.jk.service.ExamPlaceCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

@RestController
@RequestMapping("/examPlaceCourses")
@Api(tags = "课程")
public class ExamPlaceCourseController extends BaseController<ExamPlaceCourse, ExamPlaceCourseReqVo>{
    @Autowired
    private ExamPlaceCourseService service;




    @GetMapping
    @ApiOperation("分页查询")
    public PageJsonVo<ExamPlaceCourseVo> list(ExamPlaceCoursePageReqVo query) {

       /*  Map<String, Object> map = new HashMap<>();
       map.put("code", 0);
        map.put("msg", "");
        map.put("count",query.getCount());
        map.put("data", query.getData());
*/
        return JsonVos.ok(service.list(query));
    }



    @Override

    protected IService<ExamPlaceCourse> getService() {
        return service;
    }

    @Override
    protected Function<ExamPlaceCourseReqVo, ExamPlaceCourse> getFunction() {
        return MapStructs.INSTANCE::reqVo2po;
    }


}

















