package com.xuweichao.rocketmqproducer.controller;

import com.xuweichao.rocketmqproducer.rockecmq.RocketMqProducer;
import com.xuweichao.rocketmqproducer.rockecmq.RocketMqStarterProducer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class RocketMqProducerController {


    @Value("${apache.rocketmq.topic}")
    private String topic;

    @Resource
    private RocketMqStarterProducer starterProducer;
    @Resource
    private RocketMqProducer producer;

    @RequestMapping("/send")
    public String send() {
        try {
            Message msg;
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello RocketMQ " + i);
                msg = new Message(topic, ("Hello RocketMQ " + i).getBytes());
                SendResult send = producer.getProducter().send(msg);
                SendStatus sendStatus = send.getSendStatus();

                System.out.println("sendStatus--->>" + sendStatus);
            }
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "SEND SUCCESS";
    }

    @RequestMapping("/send2")
    public String starterSend() {
        for (int i = 0; i < 10; i++) {
//            starterProducer.sendAsyncMsg("RocketMQ-starter-sendAsyncMsg:"+i);
            starterProducer.sendMsg(System.currentTimeMillis()+" RocketMQ-starter-sendMsg:" + i);
            starterProducer.sendDelayMsg(
                    System.currentTimeMillis() + " RocketMQ-starter-sendDelayMsg:" + i,
                    3);
//            starterProducer.sendTagMsg("RocketMQ-starter-sendTagMsg:" + i);
        }
        return "SEND SUCCESS";
    }
}
