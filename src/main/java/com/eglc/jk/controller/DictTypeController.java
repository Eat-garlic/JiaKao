package com.eglc.jk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eglc.jk.pojo.po.DictType;
import com.eglc.jk.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.*;

@RestController
@RequestMapping("/dictTypes")
public class DictTypeController {
    @Autowired
    private DictTypeService service;

    @GetMapping
    public Map<String, Object> list(Long page, Long size, String keyword) {
        IPage<DictType> iPage = service.list(page, size, keyword);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", iPage.getTotal());
        map.put("data", iPage.getRecords());
        return map;
    }


    @PostMapping("/remove")
    public Map<String, Object> remove(String id) {

        Map<String, Object> map = new HashMap<>();
        if (service.removeByIds(Arrays.asList(id.split(",")))) {
            map.put("code", 0);
            map.put("msg", "删除成功");
        } else {
            new RuntimeException("删除失败");
        }
        return map;

    };



    @PostMapping("/save")
    public Map<String, Object> save(DictType dictType){
        Map<String, Object> map = new HashMap<>();
        if(service.saveOrUpdate(dictType)) {
            map.put("code", 0);
            map.put("msg", "保存成功");

        }else {
            new RuntimeException("保存失败");
            }

        return  map;
        }




    }

















