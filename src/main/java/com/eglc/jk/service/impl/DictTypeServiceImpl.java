package com.eglc.jk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eglc.jk.mapper.DictTypeMapper;
import com.eglc.jk.pojo.po.DictType;
import com.eglc.jk.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {

    @Autowired
    DictTypeMapper mapper;

    @Override
    public IPage<DictType> list(Long page, Long size, String keyword) {


        LambdaQueryWrapper<DictType> wrapper = new LambdaQueryWrapper<>();
            wrapper.like(DictType::getIntro,keyword).or()
                    .like(DictType::getName,keyword).or()
                    .like(DictType::getValue,keyword);


        return mapper.selectPage(new Page<>(page, size), wrapper);



        //  return  mapper.selectPage(mpPage,size).getRecords();
    }

}

