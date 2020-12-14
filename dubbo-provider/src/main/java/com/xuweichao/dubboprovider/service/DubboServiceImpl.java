package com.xuweichao.dubboprovider.service;

import com.xuweichao.dubbo.service.DubboService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

@Service(version = "1.0.0", interfaceClass = DubboService.class)
public class DubboServiceImpl implements DubboService {

    @Value("${server.port}")
    private String port;
    @Override
    public void ins() {
        System.out.println("insert---->>"+port);
    }

    @Override
    public void del() {
        System.out.println("delete---->>"+port);
    }

    @Override
    public void upd() {
        System.out.println("update---->>"+port);
    }

    @Override
    public void sel() {
        System.out.println("select---->>"+port);
    }
}
