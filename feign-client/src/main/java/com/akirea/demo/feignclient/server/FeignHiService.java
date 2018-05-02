package com.akirea.demo.feignclient.server;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * springcloud
 *
 * @auther Akira Liu
 * @date 2018/4/28
 */
@FeignClient(value = "service-hi", fallback = FeignHiServerFallback.class)
public interface FeignHiService {
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam("name") String name);
}
