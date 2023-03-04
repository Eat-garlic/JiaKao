package com.eglc.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eglc.jk.common.enhance.MpPage;
import com.eglc.jk.common.enhance.MpLambadQueryWrapper;
import com.eglc.jk.common.mapStruct.MapStructs;
import com.eglc.jk.mapper.DictTypeMapper;
import com.eglc.jk.pojo.po.DictType;
import com.eglc.jk.pojo.vo.PageVo;
import com.eglc.jk.pojo.vo.req.list.DictTypeVo;
import com.eglc.jk.pojo.vo.req.page.DictTypePageReqVo;
import com.eglc.jk.service.DictTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {

    @Override
    @Transactional(readOnly = true)
    public PageVo<DictTypeVo> list(DictTypePageReqVo query) {
        MpLambadQueryWrapper<DictType> wrapper = new MpLambadQueryWrapper<>();
        wrapper.like(query.getKeyword(),DictType::getIntro,
                                        DictType::getName,
                                        DictType::getValue);

        wrapper.orderByDesc(DictType::getId);

        return baseMapper.selectPage(new MpPage<>(query),wrapper).buildVo(MapStructs.INSTANCE::po2vo);



    }

}

