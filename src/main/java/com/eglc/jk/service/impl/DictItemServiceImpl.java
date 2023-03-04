package com.eglc.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eglc.jk.common.enhance.MpPage;
import com.eglc.jk.common.enhance.MpLambadQueryWrapper;
import com.eglc.jk.common.mapStruct.MapStructs;
import com.eglc.jk.mapper.DictItemMapper;
import com.eglc.jk.pojo.po.DictItem;
import com.eglc.jk.pojo.vo.PageVo;
import com.eglc.jk.pojo.vo.req.list.DictItemVo;
import com.eglc.jk.pojo.vo.req.page.DictItemPageReqVo;
import com.eglc.jk.service.DictItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem>implements DictItemService {
    @Override
    @Transactional(readOnly = true)
    public PageVo<DictItemVo> list(DictItemPageReqVo query) {

        MpLambadQueryWrapper<DictItem> wrapper = new MpLambadQueryWrapper<>();

        wrapper.like(query.getKeyword(),DictItem::getName,DictItem::getValue);


        Integer typeId = query.getTypeId();
        if (typeId != null && typeId > 0){
            wrapper.eq(DictItem::getTypeId, typeId);
        }

        wrapper.orderByDesc(DictItem::getId);

         return baseMapper.selectPage(new MpPage<>(query),wrapper).buildVo(MapStructs.INSTANCE::po2vo);



    }
}
