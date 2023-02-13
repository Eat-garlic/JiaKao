package com.eglc.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eglc.jk.common.util.Rs;
import com.eglc.jk.pojo.po.ExamPlace;
import com.eglc.jk.pojo.query.ExamPlaceQuery;
import com.eglc.jk.pojo.result.R;
import com.eglc.jk.service.ExamPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/examPlaces")
public class ExamPlaceController extends BaseController<ExamPlace>{
    @Autowired
    private ExamPlaceService service;

    @GetMapping
    public R list(ExamPlaceQuery query) {
        service.list(query);
       /*  Map<String, Object> map = new HashMap<>();
       map.put("code", 0);
        map.put("msg", "");
        map.put("count",query.getCount());
        map.put("data", query.getData());
*/
        return Rs.ok(query);
    }


    @Override

    protected IService<ExamPlace> getService() {
        return service;
    }


    }

















