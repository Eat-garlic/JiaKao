package com.mj.jk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mj.jk.pojo.po.DictType;
import com.mj.jk.pojo.query.DictTypeQuery;
import java.util.List;  

public interface DictTypeMapper extends BaseMapper<DictType> {
    List<DictType> select( DictTypeQuery query);

}

