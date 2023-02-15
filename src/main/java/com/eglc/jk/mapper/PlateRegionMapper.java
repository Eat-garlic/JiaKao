package com.eglc.jk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eglc.jk.pojo.dto.ProvinceDto;
import com.eglc.jk.pojo.po.PlateRegion;

import java.util.List;

public interface PlateRegionMapper extends BaseMapper<PlateRegion> {

    List<ProvinceDto> selectRegions();
}
