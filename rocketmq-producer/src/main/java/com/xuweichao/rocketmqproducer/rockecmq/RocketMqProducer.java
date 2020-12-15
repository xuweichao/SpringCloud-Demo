package com.xuweichao.rocketmqproducer.rockecmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class RocketMqProducer {
    @Value("${apache.rocketmq.consumerGroup}")
    private String consumerGroup;

    @Value("${apache.rocketmq.namesrvAddr}")
    private String namesrvAddr;

    private DefaultMQProducer producer;

    public DefaultMQProducer getProducter() {
        return producer;
    }

    @PostConstruct
    public void init() {
        producer = new DefaultMQProducer(consumerGroup);
        producer.setNamesrvAddr(namesrvAddr);
        producer.setVipChannelEnabled(false);
        try {
            producer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*
* @Autoware

RocketMQConfig mqConfig;

mqConfig.getProducter().send(msg);// msg为Message对象
Message类说明：
构造方法有：
public Message()
public Message(String topic, byte[] body)
public Message(String topic, String tags, byte[] body)
public Message(String topic, String tags, String keys, byte[] body)
public Message(String topic, String tags, String keys, int flag, byte[] body, boolean waitStoreMsgOK)

其中：
topic：表示消息要到的发送主题，必填，例如配置文件中设置的consumerTopic
tags：表示消息的标签，消费者在消费时，可以根据标签进行过滤，需要注意的是，一个生产者，只能指定一个tag
keys：用于建立索引，之后可以通过命令工具/API/或者管理平台查询key，可以为一个消息设置多个key，用空格""进行分割
flag：选填，消息的标记，完全由应用设置，RocketMQ不做任何处理
body：消息的内容，这是一个字节数组，序列化方式由应用决定，例如你可以将一个json转为字节数组
waitStoreMsgOK：表示发送消息后，是否需要等待消息同步刷新到磁盘上。如果broker配置为ASYNC_MASTER，
* 那么只需要消息在master上刷新到磁盘即可；如果配置为SYNC_MASTER，那么还需要等待slave也刷新到磁盘。
* 需要注意的是，waitStoreMsgOK默认为false，只有将设置为true的情况下，才会等待刷盘成功再返回。
* */
}
