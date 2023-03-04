package com.eglc.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eglc.jk.pojo.po.DictType;
import com.eglc.jk.pojo.vo.PageVo;
import com.eglc.jk.pojo.vo.req.list.DictTypeVo;
import com.eglc.jk.pojo.vo.req.page.DictTypePageReqVo;

public interface DictTypeService extends IService<DictType> {
   PageVo<DictTypeVo> list(DictTypePageReqVo query) ;


}
