package com.eglc.jk.common.mapStruct;

import com.eglc.jk.pojo.po.*;
import com.eglc.jk.pojo.vo.LoginVo;
import com.eglc.jk.pojo.vo.req.list.*;
import com.eglc.jk.pojo.vo.req.page.SysUserPageReqVo;
import com.eglc.jk.pojo.vo.req.save.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * ReqVo -> Po
 * Po -> Vo
 */
@Mapper(uses = {
        MapStructFormatter.class
})
public interface MapStructs {
    MapStructs INSTANCE = Mappers.getMapper(MapStructs.class);
    //根据这个接口生成代理 对象 ，接口中的这些方法全是  ，那么就是拿到这个instance代理对象来调用
    // 这些实例方法，但是这个框架是编译类，它其实是编译出来的实现类，不是代理类，但逻辑是上面写的逻辑，

    DictItemVo po2vo(DictItem po);
    DictTypeVo po2vo(DictType po);
    ExamPlaceVo po2vo(ExamPlace po);
    PlateRegionVo po2vo(PlateRegion po);
    ExamPlaceCourseVo po2vo(ExamPlaceCourse po);
    @Mapping(source = "loginTime",
            target = "loginTime",
            qualifiedBy = MapStructFormatter.Date2Millis.class)
    SysUserVo po2vo(SysUser po);
    LoginVo po2loginVo(SysUser po);
    SysRoleVo po2vo(SysRole po);
    SysResourceVo po2vo(SysResource po);



    DictItem reqVo2po(DictItemReqVo reqVo);
    DictType reqVo2po(DictTypeReqVo reqVo);
    ExamPlace reqVo2po(ExamPlaceReqVo reqVo);
    PlateRegion reqVo2po(PlateRegionReqVo reqVo);
    ExamPlaceCourse reqVo2po(ExamPlaceCourseReqVo reqVo);
    SysUser reqVo2po(SysUserPageReqVo sysUserPageReqVo);
    SysUser reqVo2po(SysUserReqVo reqVo);
    SysRole reqVo2po(SysRoleReqVo reqVo);
    SysResource reqVo2po(SysResourceReqVo reqVo);


}
