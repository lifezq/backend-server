package com.dpi.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Package com.dpi.account.controller
 * @ClassName AppController
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/19
 */
@Controller
@RequestMapping("/app")
public class AppController {

    @GetMapping("/iot/{tenant}")
    public String iot(@PathVariable String tenant, Model model) {
        model.addAttribute("tenant", tenant);
        return "/app/iot";
    }

    @GetMapping("/develop/{tenant}")
    public String develop(@PathVariable String tenant, Model model) {
        model.addAttribute("tenant", tenant);
        return "/app/develop";
    }
}
