package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 蒋加济
 * @email jiangjj5@aisainfo.com
 * @date 2019/8/21 16:08
 */
@Controller
public class Hello2Controller {

    @GetMapping(value = "hello2")
    public String hello() {
        return "hello";
    }
}
