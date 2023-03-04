package com.eglc.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eglc.jk.common.mapStruct.MapStructs;
import com.eglc.jk.common.util.JsonVos;
import com.eglc.jk.pojo.po.DictItem;
import com.eglc.jk.pojo.vo.PageJsonVo;
import com.eglc.jk.pojo.vo.req.list.DictItemVo;
import com.eglc.jk.pojo.vo.req.page.DictItemPageReqVo;
import com.eglc.jk.pojo.vo.req.save.DictItemReqVo;
import com.eglc.jk.service.DictItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

@RestController
@RequestMapping("/dictItems")
@Api(tags = "数据字典模块")
public class DictItemController extends BaseController<DictItem, DictItemReqVo> {
    @Autowired
    private DictItemService service;

    @GetMapping
    @ApiOperation("分页查询")
    public PageJsonVo<DictItemVo> list(DictItemPageReqVo query) {

        /*
         Map<String, Object> map = new HashMap<>();
       map.put("code", 0);
        map.put("msg", "");
        map.put("count",query.getCount());
        map.put("data", query.getData());
*/

        return JsonVos.ok(service.list(query));
    }



    @Override
    protected  IService<DictItem> getService() {
        return service;
    }

    @Override
    protected Function<DictItemReqVo, DictItem> getFunction() {
        return MapStructs.INSTANCE::reqVo2po;
    }


}

















