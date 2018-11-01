package com.springcloud.demo.eurekaclientzipkinservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: SpringCloud-Demo
 * @BelongsPackage: com.springcloud.demo.eurekaclient.controller
 * @Author: admin
 * @CreateTime: 2018-10-19 14:53
 * @Description: ${Description}
 */
@RestController
public class IndexController {
    @Value("${server.port}")
    private int port;

    @GetMapping("main")
    public int main() {
        return port;
    }
}
