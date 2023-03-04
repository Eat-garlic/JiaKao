package com.eglc.jk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eglc.jk.pojo.po.PlateRegion;
import com.eglc.jk.pojo.vo.req.list.ProvinceVo;

import java.util.List;

public interface PlateRegionMapper extends BaseMapper<PlateRegion> {

    List<ProvinceVo> selectRegions();
}
