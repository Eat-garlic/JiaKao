package com.mj.jk.controller;

import com.mj.jk.pojo.query.DictTypeQuery;
import com.mj.jk.serveice.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/dictTypes")
public class DictTypeController {

  @Autowired
  DictTypeService service;

    @GetMapping("/list")
    public String list (DictTypeQuery query, Model model){

          model.addAttribute("data", service.list(query));


        return "pages/dictType";
    }



}
