package com.akira.demo.serverribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * springcloud
 *
 * @auther Akira Liu
 * @date 2018/4/28
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiServerFallBack")
    public String hiServer(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

    public String hiServerFallBack(String name) {
        return "喔嚯，烂了," + name;
    }
}
