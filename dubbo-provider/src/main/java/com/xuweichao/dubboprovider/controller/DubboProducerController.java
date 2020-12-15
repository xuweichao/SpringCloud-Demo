package com.xuweichao.dubboprovider.controller;

import com.xuweichao.dubbo.service.DubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DubboProducerController {


    @Reference(version = "1.0.0")
    private DubboService dubboService;


    @RequestMapping("/ins")
    public String ins() {
        dubboService.ins();
        return "ins";
    }

    @RequestMapping("/del")
    public String del() {
        dubboService.del();
        return "del";
    }

    @RequestMapping("/upd")
    public String upd() {
        dubboService.upd();
        return "upd";
    }

    @RequestMapping("/sel")
    public String sel() {
        dubboService.sel();
        return "sel";
    }


}
