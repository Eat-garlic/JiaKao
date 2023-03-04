package com.eglc.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eglc.jk.pojo.po.PlateRegion;
import com.eglc.jk.pojo.vo.PageVo;
import com.eglc.jk.pojo.vo.req.list.PlateRegionVo;
import com.eglc.jk.pojo.vo.req.list.ProvinceVo;
import com.eglc.jk.pojo.vo.req.page.CityPageReqVo;
import com.eglc.jk.pojo.vo.req.page.ProvincePageReqVo;

import java.util.List;


public interface PlateRegionService extends IService<PlateRegion> {

    List <ProvinceVo>listRegions();

    PageVo<PlateRegionVo> listProvinces(ProvincePageReqVo query);


    PageVo<PlateRegionVo> listCities(CityPageReqVo query);

    List<PlateRegionVo> listProvinces();


}
