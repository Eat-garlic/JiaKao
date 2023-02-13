package com.eglc.jk.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eglc.jk.common.enhance.MpPage;
import com.eglc.jk.common.enhance.MpQueryWrapper;
import com.eglc.jk.mapper.PlateRegionMapper;
import com.eglc.jk.pojo.po.PlateRegion;
import com.eglc.jk.pojo.query.CityQuery;
import com.eglc.jk.pojo.query.ProvinceQuery;
import com.eglc.jk.service.PlateRegionService;
import com.github.promeg.pinyinhelper.Pinyin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PlateRegionServiceImpl extends ServiceImpl<PlateRegionMapper, PlateRegion> implements PlateRegionService {

    @Override
    public boolean save(PlateRegion entity) {
        processPinyin(entity);
        return super.save(entity);
    }


    @Override
    public boolean updateById(PlateRegion entity) {
         processPinyin(entity);
        return super.updateById(entity);

    }


    private void processPinyin(PlateRegion region) {

        String name = region.getName();
        if (name == null) return;

        region.setPinyin(Pinyin.toPinyin(name,"_"));


    }

    @Override
    @Transactional(readOnly = true)
    public void listProvinces(ProvinceQuery query) {
        MpQueryWrapper<PlateRegion> wrapper = new MpQueryWrapper<>();
        wrapper.like(query.getKeyword(), PlateRegion::getName,
                                         PlateRegion::getPinyin,
                                         PlateRegion::getPlate);
        //查省份
        wrapper.eq(PlateRegion::getParentId,0);

        baseMapper.selectPage( new MpPage<>(query), wrapper).updateQuery(query);

    }



    @Override
    public void  listCities(CityQuery query) {
        MpQueryWrapper<PlateRegion> wrapper = new MpQueryWrapper<>();
        wrapper.like(query.getKeyword(), PlateRegion::getName,
                PlateRegion::getPinyin,
                PlateRegion::getPlate);

        Integer parentId = query.getParentId();
        if (parentId != null && parentId > 0 ){
            //parentId下面的所有城市
            wrapper.eq(PlateRegion::getParentId, parentId);}
        else {
            //查所有城市
            wrapper.ne(PlateRegion::getParentId, 0);
        };


        baseMapper.selectPage( new MpPage<>(query), wrapper).updateQuery(query);

    }

    @Override
    public List<PlateRegion> listProvinces() {
        MpQueryWrapper<PlateRegion> wrapper = new MpQueryWrapper<>();

        wrapper.eq(PlateRegion::getParentId,0);
        return  baseMapper.selectList(wrapper);
    }
}


