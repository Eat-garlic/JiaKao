package com.eglc.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eglc.jk.common.util.Rs;
import com.eglc.jk.pojo.po.PlateRegion;
import com.eglc.jk.pojo.query.CityQuery;
import com.eglc.jk.pojo.query.ProvinceQuery;
import com.eglc.jk.pojo.result.R;
import com.eglc.jk.service.PlateRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/plateRegions")
public class PlateRegionController extends BaseController<PlateRegion>{

    @Autowired
    private PlateRegionService service;


    @GetMapping("/regions")
    public R listRegion() {

       /*  Map<String, Object> map = new HashMap<>();
       map.put("code", 0);
        map.put("msg", "");
        map.put("count",query.getCount());
        map.put("data", query.getData());
*/
        return Rs.ok(service.listRegions());
    }


    @GetMapping("/provinces")
    public R listProvinces(ProvinceQuery query) {
        service.listProvinces(query);
       /*  Map<String, Object> map = new HashMap<>();
       map.put("code", 0);
        map.put("msg", "");
        map.put("count",query.getCount());
        map.put("data", query.getData());
*/
        return Rs.ok(query);
    }


    @GetMapping("/cities")
    public  R  listCities (CityQuery query){
        service.listCities(query);
        return  Rs.ok(query);
    }

    @GetMapping("/provinces/list")
    public R listProvinces(){
        return  Rs.ok(service.listProvinces());
    }

    @Override

    protected IService<PlateRegion> getService() {
        return service;
    }


    }

















