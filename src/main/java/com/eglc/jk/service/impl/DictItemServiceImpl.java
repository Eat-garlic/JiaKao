package com.eglc.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eglc.jk.mapper.DictItemMapper;
import com.eglc.jk.pojo.po.DictItem;
import com.eglc.jk.service.DictItemService;
import org.springframework.stereotype.Service;

@Service
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem>implements DictItemService {
}
