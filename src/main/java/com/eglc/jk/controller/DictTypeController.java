package com.eglc.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eglc.jk.common.mapStruct.MapStructs;
import com.eglc.jk.common.util.JsonVos;
import com.eglc.jk.common.util.Streams;
import com.eglc.jk.pojo.po.DictType;
import com.eglc.jk.pojo.vo.DataJsonVo;
import com.eglc.jk.pojo.vo.PageJsonVo;
import com.eglc.jk.pojo.vo.req.list.DictTypeVo;
import com.eglc.jk.pojo.vo.req.page.DictTypePageReqVo;
import com.eglc.jk.pojo.vo.req.save.DictTypeReqVo;
import com.eglc.jk.service.DictTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Function;


@RestController
@RequestMapping("/dictTypes")
@Api(tags = "数据字典类型")
public class DictTypeController extends BaseController<DictType, DictTypeReqVo>{
    @Autowired
    private DictTypeService service;

    @GetMapping
    @ApiOperation("分页查询")
    public PageJsonVo<DictTypeVo> list(DictTypePageReqVo query) {

       /*  Map<String, Object> map = new HashMap<>();
       map.put("code", 0);
        map.put("msg", "");
        map.put("count",query.getCount());
        map.put("data", query.getData());
*/
        return JsonVos.ok(service.list(query));
    }


    @GetMapping("/list")
    @ApiOperation("查询所有")
    public DataJsonVo<List<DictTypeVo>> list (){
        return  JsonVos.ok(Streams.map(service.list(), MapStructs.INSTANCE::po2vo));
    }

    @Override

    protected IService<DictType> getService() {
        return service;
    }

    @Override
    protected Function<DictTypeReqVo, DictType> getFunction() {
        return MapStructs.INSTANCE::reqVo2po;
    }


}

















