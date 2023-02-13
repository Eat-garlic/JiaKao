package com.eglc.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eglc.jk.common.enhance.MpPage;
import com.eglc.jk.common.enhance.MpQueryWrapper;
import com.eglc.jk.mapper.ExamPlaceMapper;
import com.eglc.jk.pojo.po.ExamPlace;
import com.eglc.jk.pojo.query.ExamPlaceQuery;
import com.eglc.jk.service.ExamPlaceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ExamPlaceServiceImpl extends ServiceImpl<ExamPlaceMapper, ExamPlace> implements ExamPlaceService {

    @Override
    @Transactional(readOnly = true)
    public void list(ExamPlaceQuery query) {


        MpQueryWrapper<ExamPlace> wrapper = new MpQueryWrapper<>();

        wrapper.like(query.getKeyword(),ExamPlace::getAddress);


        Integer cityId = query.getCityId();
        Integer provinceId = query.getProvinceId();

        if (cityId!=null && cityId >0   ) {
            wrapper.eq(ExamPlace::getCityId, cityId);
        }else if (provinceId!=null && provinceId>0){
            wrapper.eq(ExamPlace::getProvinceId,provinceId);
        }



        baseMapper.selectPage(new MpPage<>(query),wrapper).updateQuery(query);




    }
}


