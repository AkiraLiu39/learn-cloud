package com.akirea.demo.feignclient.controller;

import com.akirea.demo.feignclient.server.FeignHiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * springcloud
 *
 * @auther Akira Liu
 * @date 2018/4/28
 */
@RestController
public class HiController {
    @Autowired
    FeignHiService hiService;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name) {
        return hiService.sayHiFromClientOne(name);
    }
}
