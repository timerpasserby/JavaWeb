package com.javaweb.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")  //头部前缀
public class HomeController {
    //    @RequestMapping(value = "/home",method = RequestMethod.GET)  //可以指定方法
    @GetMapping("/home")
    public String getIndex(@RequestParam(name = "name", defaultValue = "sssss") String name) {
        return "hello" + name;
    }


    @PostMapping("/data")
    public String postData() {
        return "hello";
    }
}
