package com.eglc.jk.service.impl;

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
    public IPage list(Long page, Long size) {
        Page<DictType> mpPage = new Page<>(page, size);


        return mapper.selectPage(mpPage, null);

        //  return  mapper.selectPage(mpPage,size).getRecords();
    }

}

