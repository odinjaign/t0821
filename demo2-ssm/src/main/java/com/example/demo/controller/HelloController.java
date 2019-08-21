package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 蒋加济
 * @email jiangjj5@aisainfo.com
 * @date 2019/8/21 16:08
 */
@RestController
public class HelloController {

    @GetMapping(value = "hello")
    public String hello() {
        return "hello";
    }

    @GetMapping(value = "map")
    public Map<String,Object> map(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","Jaign");
        map.put("age",21);
        map.put("info","SomeOtherInfoMessages");
        return map;
    }
}
