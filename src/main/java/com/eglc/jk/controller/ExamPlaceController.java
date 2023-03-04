package com.eglc.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eglc.jk.common.mapStruct.MapStructs;
import com.eglc.jk.common.util.JsonVos;
import com.eglc.jk.pojo.po.ExamPlace;
import com.eglc.jk.pojo.vo.DataJsonVo;
import com.eglc.jk.pojo.vo.PageJsonVo;
import com.eglc.jk.pojo.vo.req.list.ExamPlaceVo;
import com.eglc.jk.pojo.vo.req.list.ProvinceVo;
import com.eglc.jk.pojo.vo.req.page.ExamPlacePageReqVo;
import com.eglc.jk.pojo.vo.req.save.ExamPlaceReqVo;
import com.eglc.jk.service.ExamPlaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Function;


@RestController
@RequestMapping("/examPlaces")
@Api(tags = "考场")
public class ExamPlaceController extends BaseController<ExamPlace, ExamPlaceReqVo>{
    @Autowired
   private ExamPlaceService service;

    @GetMapping
    @ApiOperation("分页查询")
    public PageJsonVo<ExamPlaceVo>list(ExamPlacePageReqVo query) {

       /*  Map<String, Object> map = new HashMap<>();
       map.put("code", 0);
        map.put("msg", "");
        map.put("count",query.getCount());
        map.put("data", query.getData());
*/
        return JsonVos.ok( service.list(query));
    }




    @GetMapping("/regionExamPlaces")
    @ApiOperation("查询所有区域下面的考场")
    public DataJsonVo<List<ProvinceVo>> listRegionExamPlaces() {

       /*  Map<String, Object> map = new HashMap<>();
       map.put("code", 0);
        map.put("msg", "");
        map.put("count",query.getCount());
        map.put("data", query.getData());
*/
        return JsonVos.ok(service.listRegionExamPlaces());
    }



    @Override

    protected IService<ExamPlace> getService() {
        return service;
    }

    @Override
    protected Function<ExamPlaceReqVo, ExamPlace> getFunction() {
        return MapStructs.INSTANCE::reqVo2po;
    }


}

















