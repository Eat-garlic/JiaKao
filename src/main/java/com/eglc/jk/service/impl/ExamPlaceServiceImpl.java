package com.eglc.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eglc.jk.common.enhance.MpPage;
import com.eglc.jk.common.enhance.MpLambadQueryWrapper;
import com.eglc.jk.common.mapStruct.MapStructs;
import com.eglc.jk.mapper.ExamPlaceMapper;
import com.eglc.jk.pojo.po.ExamPlace;
import com.eglc.jk.pojo.vo.PageVo;
import com.eglc.jk.pojo.vo.req.list.ExamPlaceVo;
import com.eglc.jk.pojo.vo.req.list.ProvinceVo;
import com.eglc.jk.pojo.vo.req.page.ExamPlacePageReqVo;
import com.eglc.jk.service.ExamPlaceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ExamPlaceServiceImpl extends ServiceImpl<ExamPlaceMapper, ExamPlace> implements ExamPlaceService {

    @Override
    @Transactional(readOnly = true)
    public PageVo<ExamPlaceVo> list(ExamPlacePageReqVo query) {
        MpLambadQueryWrapper<ExamPlace> wrapper = new MpLambadQueryWrapper<>();
        wrapper.like(query.getKeyword(),ExamPlace::getAddress);
        Integer cityId = query.getCityId();
        Integer provinceId = query.getProvinceId();

        if (cityId!=null && cityId >0   ) {
            wrapper.eq(ExamPlace::getCityId, cityId);
        }else if (provinceId!=null && provinceId>0){
            wrapper.eq(ExamPlace::getProvinceId,provinceId);
        }
        return baseMapper.selectPage(new MpPage<>(query),wrapper).buildVo(MapStructs.INSTANCE::po2vo);
    }

    @Override
    public List<ProvinceVo> listRegionExamPlaces() {

        return baseMapper.selectRegionExamPlaces();
    }
}


