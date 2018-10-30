package com.springcloud.demo.eurekaclientzipkin.controller;

/**
 * @BelongsProject: SpringCloud-Demo
 * @BelongsPackage: com.springcloud.demo.eurekaclientribbon.controller
 * @Author: admin
 * @CreateTime: 2018-10-22 14:15
 * @Description: ${Description}
 */

import com.springcloud.demo.eurekaclientzipkin.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    RibbonService ribbonService;

    @GetMapping("main")
    public int main() {
        return ribbonService.main();
    }
}
