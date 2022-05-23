package com.mj.jk.controller;

import com.mj.jk.pojo.po.DictType;
import com.mj.jk.serveice.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dictType")
public class DictTypeController {

  @Autowired
  DictTypeService dictTypeService;

    @GetMapping("/list")
    public List<DictType> list (){

        return dictTypeService.list();
    }



}
