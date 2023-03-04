package com.eglc.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eglc.jk.common.mapStruct.MapStructs;
import com.eglc.jk.common.util.JsonVos;
import com.eglc.jk.pojo.po.PlateRegion;
import com.eglc.jk.pojo.vo.DataJsonVo;
import com.eglc.jk.pojo.vo.PageJsonVo;
import com.eglc.jk.pojo.vo.req.list.PlateRegionVo;
import com.eglc.jk.pojo.vo.req.list.ProvinceVo;
import com.eglc.jk.pojo.vo.req.page.CityPageReqVo;
import com.eglc.jk.pojo.vo.req.page.ProvincePageReqVo;
import com.eglc.jk.pojo.vo.req.save.PlateRegionReqVo;
import com.eglc.jk.service.PlateRegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Function;


@RestController
@RequestMapping("/plateRegions")
@Api(tags = "省份，城市")
public class PlateRegionController extends BaseController<PlateRegion, PlateRegionReqVo>{

    @Autowired
    private PlateRegionService service;


    @GetMapping("/regions")
    @ApiOperation("查询所有区域，包含省份城市")
    public DataJsonVo<List<ProvinceVo>> listRegion() {

       /*  Map<String, Object> map = new HashMap<>();
       map.put("code", 0);
        map.put("msg", "");
        map.put("count",query.getCount());
        map.put("data", query.getData());
*/
        return JsonVos.ok(service.listRegions());
    }


    @GetMapping("/provinces")
    @ApiOperation("分页查询省份")
    public PageJsonVo<PlateRegionVo> listProvinces(ProvincePageReqVo query) {

       /*  Map<String, Object> map = new HashMap<>();
       map.put("code", 0);
        map.put("msg", "");
        map.put("count",query.getCount());
        map.put("data", query.getData());
*/
        return JsonVos.ok(service.listProvinces(query));
    }


    @GetMapping("/provinces/list")
    @ApiOperation("查询所有省份")
    public DataJsonVo<List<PlateRegionVo>> listProvinces(){
        return  JsonVos.ok(service.listProvinces());
    }


    @GetMapping("/cities")
    @ApiOperation("分页查询城市")
    public PageJsonVo<PlateRegionVo>  listCities (CityPageReqVo query){

        return  JsonVos.ok( service.listCities(query));
    }


    @Override

    protected IService<PlateRegion> getService() {
        return service;
    }

    @Override
    protected Function<PlateRegionReqVo, PlateRegion> getFunction() {
        return MapStructs.INSTANCE::reqVo2po;
    }


}

















