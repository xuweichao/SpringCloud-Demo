package com.springcloud.demo.eurekaclientfeign.conf;

import com.springcloud.demo.eurekaclientfeign.service.GetMsgFromClientService;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: SpringCloud-Demo
 * @BelongsPackage: com.springcloud.demo.eurekaclientfeign.conf
 * @Author: admin
 * @CreateTime: 2018-10-22 11:01
 * @Description: 熔断器错误回调
 */
@Component
public class MainHystrixError implements GetMsgFromClientService {
    @Override
    public int main() {
        return -1;
    }
}
