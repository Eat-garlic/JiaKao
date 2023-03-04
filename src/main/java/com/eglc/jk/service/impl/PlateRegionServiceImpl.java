package com.eglc.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eglc.jk.common.enhance.MpPage;
import com.eglc.jk.common.enhance.MpLambadQueryWrapper;
import com.eglc.jk.common.mapStruct.MapStructs;
import com.eglc.jk.common.util.Streams;
import com.eglc.jk.mapper.PlateRegionMapper;
import com.eglc.jk.pojo.po.PlateRegion;
import com.eglc.jk.pojo.vo.PageVo;
import com.eglc.jk.pojo.vo.req.list.PlateRegionVo;
import com.eglc.jk.pojo.vo.req.list.ProvinceVo;
import com.eglc.jk.pojo.vo.req.page.CityPageReqVo;
import com.eglc.jk.pojo.vo.req.page.ProvincePageReqVo;
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




    //查省份
    @Override
    @Transactional(readOnly = true)
    public PageVo<PlateRegionVo> listProvinces(ProvincePageReqVo query) {
        MpLambadQueryWrapper<PlateRegion> wrapper = new MpLambadQueryWrapper<>();
        wrapper.like(query.getKeyword(), PlateRegion::getName,
                                         PlateRegion::getPinyin,
                                         PlateRegion::getPlate);
        //查省份
        wrapper.eq(PlateRegion::getParentId,0);

        return baseMapper.selectPage(new MpPage<>(query),wrapper).buildVo(MapStructs.INSTANCE::po2vo);

    }


    //查城市
    @Override
    public PageVo<PlateRegionVo>  listCities(CityPageReqVo query) {
        MpLambadQueryWrapper<PlateRegion> wrapper = new MpLambadQueryWrapper<>();
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
        return baseMapper.selectPage(new MpPage<>(query),wrapper).buildVo(MapStructs.INSTANCE::po2vo);

    }


    //查所有城市（城市模块， 点击城市 就出现城市模块的那个功能）
    @Override
    public List<PlateRegionVo> listProvinces() {
        MpLambadQueryWrapper<PlateRegion> wrapper = new MpLambadQueryWrapper<>();
        wrapper.eq(PlateRegion::getParentId,0);
        return Streams.map(baseMapper.selectList(wrapper), MapStructs.INSTANCE::po2vo);
    }



        //查所有
        @Override
        public List<ProvinceVo> listRegions() {
            return baseMapper.selectRegions();
        }


}


