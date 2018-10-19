package com.springcloud.demo.eurekaclientfeign.service;

import com.springcloud.demo.eurekaclientfeign.conf.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @BelongsProject: SpringCloud-Demo
 * @BelongsPackage: com.springcloud.demo.eurekaclientfeign.controller
 * @Author: admin
 * @CreateTime: 2018-10-19 17:34
 * @Description: ${Description}
 */
@FeignClient(value = "eureka-client", configuration = FeignConfig.class)
public interface GetMsgFromServerService {
    @GetMapping("main")
    int main();
}
