package com.eglc.jk.controller;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eglc.jk.common.exception.CommonException;
import com.eglc.jk.pojo.po.DictItem;
import com.eglc.jk.pojo.query.DictItemQuery;
import com.eglc.jk.pojo.result.R;
import com.eglc.jk.common.util.Rs;
import com.eglc.jk.service.DictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/dictItems")
public class DictItemController extends BaseController<DictItem> {
    @Autowired
    private DictItemService service;

    @GetMapping
    public R list(DictItemQuery query) {
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
    protected  IService<DictItem> getService() {
        return service;
    }


}

















