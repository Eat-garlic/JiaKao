package com.eglc.jk.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eglc.jk.pojo.po.DictType;
import com.eglc.jk.pojo.query.DictTypeQuery;

public interface DictTypeService extends IService<DictType> {
   void list(DictTypeQuery query) ;


}
