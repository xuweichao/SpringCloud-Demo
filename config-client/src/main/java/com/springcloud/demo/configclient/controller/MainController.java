package com.springcloud.demo.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: SpringCloud-Demo
 * @BelongsPackage: com.springcloud.demo.configclient.controller
 * @Author: admin
 * @CreateTime: 2018-10-23 14:02
 * @Description: ${Description}
 */
@RestController
public class MainController {
    @Value("${application.name}")
    private String name;

    @GetMapping("main")
    public String main() {
        return name;
    }
}
