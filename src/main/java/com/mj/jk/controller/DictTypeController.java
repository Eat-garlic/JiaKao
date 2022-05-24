package com.mj.jk.controller;

import com.mj.jk.pojo.query.KeywordQuery;
import com.mj.jk.serveice.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/dictType")
public class DictTypeController {

  @Autowired
  DictTypeService dictTypeService;

    @GetMapping("/list")
    public String list (Model model, KeywordQuery query){

          model.addAttribute("data", dictTypeService.list());

        return "pages/dictType";
    }



}
