package com.mj.jk.serveice.impl;

import com.mj.jk.mapper.DictTypeMapper;
import com.mj.jk.pojo.po.DictType;
import com.mj.jk.serveice.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DictTypeServiceImpl implements DictTypeService {


    @Autowired
    DictTypeMapper dictTypeMapper;

    @Override
    @Transactional(readOnly = true)
    public List<DictType> list() {

        return dictTypeMapper.list();
    }
}
