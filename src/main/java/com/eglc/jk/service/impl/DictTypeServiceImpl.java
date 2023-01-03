package com.eglc.jk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eglc.jk.common.enhance.MpPage;
import com.eglc.jk.mapper.DictTypeMapper;
import com.eglc.jk.pojo.po.DictType;
import com.eglc.jk.pojo.query.DictTypeQuery;
import com.eglc.jk.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {

    @Autowired
    DictTypeMapper mapper;

    @Override
    public void list(DictTypeQuery query) {


        LambdaQueryWrapper<DictType> wrapper = new LambdaQueryWrapper<>();
        String keyword = query.getKeyword();



        if(! StringUtils.isEmpty(keyword)) {
            wrapper.like(DictType::getIntro,keyword).or()
                    .like(DictType::getName,keyword).or()
                    .like(DictType::getValue,keyword);
        }
        wrapper.orderByDesc(DictType::getId);

        mapper.selectPage(new MpPage(query), wrapper).updateQuery(query);//select count (*) from dict_type





    }

}

