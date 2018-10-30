package com.springcloud.demo.eurekaclientfeign.service;

import com.springcloud.demo.eurekaclientfeign.conf.FeignConfig;
import com.springcloud.demo.eurekaclientfeign.conf.MainHystrixError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @BelongsProject: SpringCloud-Demo
 * @BelongsPackage: com.springcloud.demo.eurekaclientfeign.controller
 * @Author: admin
 * @CreateTime: 2018-10-19 17:34
 * @Description: ${Description}
 */
@FeignClient(value = "eureka-client", configuration = FeignConfig.class, fallback = MainHystrixError.class)
public interface FeignService {
    @GetMapping("main")
    int main();
}
