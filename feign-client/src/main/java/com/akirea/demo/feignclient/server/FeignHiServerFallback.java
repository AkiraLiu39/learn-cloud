package com.akirea.demo.feignclient.server;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * springcloud
 *
 * @auther Akira Liu
 * @date 2018/4/28
 */
@Service
public class FeignHiServerFallback implements FeignHiService {
    @Override
    public String sayHiFromClientOne(String name) {
        return "搞毛线，烂咯哟" + name;
    }
}
