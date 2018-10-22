package com.springcloud.demo.eurekaclientribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * @BelongsProject: SpringCloud-Demo
 * @BelongsPackage: com.springcloud.demo.eurekaclientribbon.service
 * @Author: admin
 * @CreateTime: 2018-10-22 14:14
 * @Description: ${Description}
 */
@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "errorFallbackMsg")
    public int main(){
        return restTemplate.getForObject("http://eureka-client/main",Integer.class);
    }

    public int errorFallbackMsg(){
        return -2;
    }
}
