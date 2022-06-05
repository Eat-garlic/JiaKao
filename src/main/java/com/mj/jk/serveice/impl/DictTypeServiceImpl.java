package com.mj.jk.serveice.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mj.jk.mapper.DictTypeMapper;
import com.mj.jk.pojo.po.DictType;
import com.mj.jk.pojo.query.DictTypeQuery;
import com.mj.jk.serveice.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {

    @Autowired
    private DictTypeMapper mapper;

    @Override
    public List<DictType> list(DictTypeQuery query) {


            //分页查询的逻辑
            LambdaQueryWrapper<DictType> wrapper = new LambdaQueryWrapper<>();
            String keyword = query.getKeyword();
            wrapper.like(DictType::getName, keyword).or()
                    .like(DictType::getValue, keyword).or()
                    .like(DictType::getIntro, keyword);

               Page<DictType> page = new Page<>(query.getPage(), query.getSize());
            return mapper.selectPage(page, wrapper).getRecords();
        }
    }


