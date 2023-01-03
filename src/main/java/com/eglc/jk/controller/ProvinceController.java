package com.eglc.jk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eglc.jk.pojo.po.Province;
import com.eglc.jk.pojo.query.ProvinceQuery;
import com.eglc.jk.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    private ProvinceService service;

    @GetMapping
    public Map<String, Object> list(ProvinceQuery query) {
        service.list(query);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", query.getCount());
        map.put("data", query.getData());
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
    public Map<String, Object> save(Province province){
        Map<String, Object> map = new HashMap<>();
        if(service.saveOrUpdate(province)) {
            map.put("code", 0);
            map.put("msg", "保存成功");

        }else {
            new RuntimeException("爱你失败");
            }

        return  map;
        }




    }

















