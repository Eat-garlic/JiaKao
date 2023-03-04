package com.eglc.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eglc.jk.common.enhance.MpPage;
import com.eglc.jk.common.enhance.MpQueryWrapper;
import com.eglc.jk.mapper.ExamPlaceCourseMapper;
import com.eglc.jk.pojo.po.ExamPlaceCourse;
import com.eglc.jk.pojo.vo.PageVo;
import com.eglc.jk.pojo.vo.req.list.ExamPlaceCourseVo;
import com.eglc.jk.pojo.vo.req.page.ExamPlaceCoursePageReqVo;
import com.eglc.jk.service.ExamPlaceCourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ExamPlaceCourseServiceImpl extends ServiceImpl<ExamPlaceCourseMapper, ExamPlaceCourse> implements ExamPlaceCourseService {


    @Override
    public PageVo<ExamPlaceCourseVo> list(ExamPlaceCoursePageReqVo query) {

        MpQueryWrapper<ExamPlaceCourseVo> wrapper = new MpQueryWrapper<>();

        Short type = query.getType();
        Integer provinceId = query.getProvinceId();
        Integer cityId = query.getCityId();
        Integer placeId = query.getPlaceId();


        //根据前台传进来的参数来查询分页查询对象
        if (type != null && type >= 0 ){
            wrapper.eq("type",type);
        }

        if (placeId != null  && placeId > 0 ){
            wrapper.eq("c.place_Id", placeId);
        }else if (cityId != null && cityId >0){
            wrapper.eq("p.city_Id", cityId);
        }else if (provinceId != null && provinceId > 0){
            wrapper.eq("p.province_Id", provinceId);
        }

            wrapper.like(query.getKeyword(),"c.name","c.intro");



        //return baseMapper.selectPage(new MpPage<>(query),wrapper).buildVo(MapStructs.INSTANCE::po2vo);
        return  baseMapper.selectPageVos(new MpPage<>(query), wrapper).buildVo();
    }
}



