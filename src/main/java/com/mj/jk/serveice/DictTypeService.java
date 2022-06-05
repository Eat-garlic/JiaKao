package com.mj.jk.serveice;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mj.jk.pojo.po.DictType;
import com.mj.jk.pojo.query.DictTypeQuery;

import java.util.List;

public interface DictTypeService extends IService<DictType> {
   List<DictType> list (DictTypeQuery query);
}
