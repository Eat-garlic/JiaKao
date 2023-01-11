package com.eglc.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eglc.jk.common.exception.CommonException;
import com.eglc.jk.pojo.po.DictType;
import com.eglc.jk.pojo.query.DictTypeQuery;
import com.eglc.jk.pojo.result.R;
import com.eglc.jk.common.util.Rs;
import com.eglc.jk.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/dictTypes")
public class DictTypeController extends BaseController<DictType>{
    @Autowired
    private DictTypeService service;

    @GetMapping
    public R list(DictTypeQuery query) {
        service.list(query);
        Map<String, Object> map = new HashMap<>();
     /*   map.put("code", 0);
        map.put("msg", "");
        map.put("count",query.getCount());
        map.put("data", query.getData());
*/
        return Rs.ok(query);
    }


    @Override
    protected IService<DictType> getService() {
        return service;
    }


    }

















