package com.eglc.jk.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.eglc.jk.common.enhance.MpPage;
import com.eglc.jk.mapper.ProvinceMapper;
import com.eglc.jk.pojo.po.Province;
import com.eglc.jk.pojo.po.Province;;
import com.eglc.jk.pojo.query.ProvinceQuery;
import com.eglc.jk.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper, Province> implements ProvinceService {




    @Override
    @Transactional(readOnly = true)
    public void  list(ProvinceQuery query) {

        LambdaQueryWrapper<Province> wrapper = new LambdaQueryWrapper<>();
        String keyword = query.getKeyword();
        if (! StringUtils.isEmpty(keyword)) {
            wrapper.like(Province::getName, keyword).or()
                    .like(Province::getPlate, keyword).or();
        }
        
        baseMapper.selectPage(new MpPage<>(query), wrapper).updateQuery(query);

    }



    }


