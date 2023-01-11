package com.eglc.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eglc.jk.pojo.po.DictItem;
import com.eglc.jk.pojo.query.DictItemQuery;

public interface DictItemService extends IService<DictItem> {
    void list(DictItemQuery query);
}
