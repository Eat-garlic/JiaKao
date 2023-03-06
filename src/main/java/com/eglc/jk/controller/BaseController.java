package com.eglc.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eglc.jk.common.util.JsonVos;
import com.eglc.jk.pojo.result.CodeMsg;
import com.eglc.jk.pojo.vo.JsonVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Validated
public abstract class BaseController<Po,ReqVo> {
   protected abstract IService<Po> getService();

   protected abstract Function<ReqVo,Po> getFunction();
    @PostMapping("/remove")
    @ApiOperation("删除一条或多条记录")
    public JsonVo remove(@ApiParam(value = "一个或多个id,多个id用逗号拼接",  required = true)
                    @NotBlank(message = "id不能为空") String id) {
        Map<String, Object> map = new HashMap<>();
        if (getService().removeByIds(Arrays.asList(id.split(",")))) { /* before1。 map.put("code", 0);  map.put("msg", "删除成功");*/
            return JsonVos.ok(CodeMsg.REMOVE_OK);
        } else {
          return JsonVos.raise(CodeMsg.REMOVE_ERROR);
        }
    };

    @PostMapping("/save")
    @ApiOperation("添加或更新")
    public JsonVo save(@Valid ReqVo reqVo){
      //  Map<String, Object> map = new HashMap<>();


        //  /* MapStructs.INSTANCE::reqVo2po;*
        //  别人返回的是函数式接口，  getFunction拿到一个req转Po的Function,  Function(函数式接口)只要apply一下就可以将t对象转为r对象   ，
        Po po = getFunction().apply(reqVo);
        if(getService().saveOrUpdate(po)) {
          /*  map.put("code", 0);
            map.put("msg", "保存成功");*/
            return JsonVos.ok(CodeMsg.SAVE_OK);
        }else {
            return JsonVos.raise(CodeMsg.SAVE_ERROR);
        }
    }

}
