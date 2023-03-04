package com.eglc.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eglc.jk.pojo.po.DictItem;
import com.eglc.jk.pojo.vo.PageVo;
import com.eglc.jk.pojo.vo.req.list.DictItemVo;
import com.eglc.jk.pojo.vo.req.page.DictItemPageReqVo;

public interface DictItemService extends IService<DictItem> {
    PageVo<DictItemVo> list(DictItemPageReqVo query);
}
