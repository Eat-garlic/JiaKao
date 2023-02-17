package com.eglc.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eglc.jk.common.util.Rs;
import com.eglc.jk.pojo.result.CodeMsg;
import com.eglc.jk.pojo.result.R;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Validated
public abstract class BaseController<T> {
   protected abstract IService<T> getService();


    @PostMapping("/remove")
    public R remove(@NotBlank(message = "id不能为空") String id) {
        Map<String, Object> map = new HashMap<>();
        if (getService().removeByIds(Arrays.asList(id.split(",")))) {
           /* map.put("code", 0);
            map.put("msg", "删除成功");*/
            return Rs.ok(CodeMsg.REMOVE_OK);
        } else {
          return Rs.raise(CodeMsg.REMOVE_ERROR);
        }
    };



    @PostMapping("/save")
    public R save(@Valid T entity){
      //  Map<String, Object> map = new HashMap<>();
        if(getService().saveOrUpdate(entity)) {
          /*  map.put("code", 0);
            map.put("msg", "保存成功");*/
            return Rs.ok(CodeMsg.SAVE_OK);
        }else {
            return Rs.raise(CodeMsg.SAVE_ERROR);
        }
    }

}
