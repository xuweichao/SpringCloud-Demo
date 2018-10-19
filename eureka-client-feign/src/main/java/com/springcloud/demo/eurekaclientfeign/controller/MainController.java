package com.springcloud.demo.eurekaclientfeign.controller;

import com.springcloud.demo.eurekaclientfeign.service.GetMsgFromServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: SpringCloud-Demo
 * @BelongsPackage: com.springcloud.demo.eurekaclientfeign.controller
 * @Author: admin
 * @CreateTime: 2018-10-19 17:42
 * @Description: ${Description}
 */
@RestController
public class MainController {
    @Autowired
    GetMsgFromServerService getMsgFromServerService;

    @GetMapping("main")
    public int getMsg() {
        return getMsgFromServerService.main();
    }
}
