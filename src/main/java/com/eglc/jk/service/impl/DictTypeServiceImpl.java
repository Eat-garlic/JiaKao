package com.eglc.jk.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eglc.jk.common.enhance.MpPage;
import com.eglc.jk.common.enhance.MpQueryWrapper;
import com.eglc.jk.mapper.DictTypeMapper;
import com.eglc.jk.pojo.po.DictType;
import com.eglc.jk.pojo.query.DictTypeQuery;
import com.eglc.jk.service.DictTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service
@Transactional
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {

    @Override
    @Transactional(readOnly = true)
    public void list(DictTypeQuery query) {
        MpQueryWrapper<DictType> wrapper = new MpQueryWrapper<>();

        wrapper.like(query.getKeyword(), DictType::getIntro,DictType::getName,DictType::getValue);

        wrapper.orderByDesc(DictType::getId);

       baseMapper.selectPage(new MpPage(query), wrapper).updateQuery(query);//select count (*) from dict_type



    }

}

