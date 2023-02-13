package com.eglc.jk.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eglc.jk.pojo.po.PlateRegion;
import com.eglc.jk.pojo.query.CityQuery;
import com.eglc.jk.pojo.query.DictTypeQuery;
import com.eglc.jk.pojo.query.ProvinceQuery;
import org.apache.ibatis.annotations.Delete;

import java.util.List;


public interface PlateRegionService extends IService<PlateRegion> {

   void  listProvinces(ProvinceQuery query);


    void listCities(CityQuery query);

    List<PlateRegion> listProvinces();
}
