package com.eglc.jk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eglc.jk.pojo.po.DictType;

import java.util.List;

public interface DictTypeService extends IService<DictType> {
   IPage list(Long page, Long size);


}
