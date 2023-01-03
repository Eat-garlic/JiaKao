package com.eglc.jk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eglc.jk.pojo.po.DictType;
import com.eglc.jk.pojo.po.Province;
import com.eglc.jk.pojo.query.ProvinceQuery;

public interface ProvinceService extends IService<Province> {
    void  list(ProvinceQuery query) ;


}
