package com.eglc.jk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eglc.jk.pojo.po.DictType;
import com.eglc.jk.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dictTypes")
public class DictTypeController {
    @Autowired
    private DictTypeService service;

    @GetMapping
    public Map<String,Object> list(Long page, Long size){
      IPage<DictType> iPage =  service.list(page,size);
        Map <String,Object>  map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        return map;
    }

}
