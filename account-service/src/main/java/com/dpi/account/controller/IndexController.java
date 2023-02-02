package com.dpi.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Package com.dpi.account.controller
 * @ClassName IndexController
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/17
 */
@RequestMapping("/")
@Controller
public class IndexController {


    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
