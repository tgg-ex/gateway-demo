package com.zmjt.gatway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zyz
 * <p>
 * 测试控制器
 */
@RestController
public class DemoController {

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @RequestMapping("/test")
    public String test() {
        return restTemplate.getForObject("http://localhost:7071/test", String.class);
    }
}
