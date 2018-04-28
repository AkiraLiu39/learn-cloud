package com.akira.demo.serverribbon.controller;

import com.akira.demo.serverribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * springcloud
 *
 * @auther Akira Liu
 * @date 2018/4/28
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiServer(name);
    }
}
