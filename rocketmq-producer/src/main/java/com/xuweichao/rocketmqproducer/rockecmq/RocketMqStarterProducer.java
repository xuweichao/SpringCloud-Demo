package com.xuweichao.rocketmqproducer.rockecmq;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class RocketMqStarterProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Value("${rocketmq.producer.send-message-timeout}")
    private Integer messageTimeOut;

    @Value("${rocketmq.producer.topic}")
    private String topic;

    /**
     * 发送普通消息
     */
    public void sendMsg(String msgBody) {
         rocketMQTemplate.send(topic, MessageBuilder.withPayload(msgBody).build());
        System.out.println("sendResult--->>");
    }

    /**
     * 发送异步消息 在SendCallback中可处理相关成功失败时的逻辑
     */
    public void sendAsyncMsg(String msgBody) {
        rocketMQTemplate.asyncSend(topic, MessageBuilder.withPayload(msgBody).build(), new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                // 处理消息发送成功逻辑
                System.out.println(sendResult.getSendStatus());
            }

            @Override
            public void onException(Throwable e) {
                // 处理消息发送异常逻辑
            }
        });
    }

    /**
     * 发送延时消息<br/>
     * 在starter版本中 延时消息一共分为18个等级分别为：1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h<br/>
     */
    public void sendDelayMsg(String msgBody, Integer delayLevel) {
        SendResult sendResult = rocketMQTemplate.syncSend(
                topic,
                MessageBuilder.withPayload(msgBody).build(),
                messageTimeOut,
                delayLevel
        );
        System.out.println("sendResult--->>" + sendResult.getSendStatus());
    }

    /**
     * 发送带tag的消息,直接在topic后面加上":tag"
     */
    public void sendTagMsg(String msgBody) {
        SendResult sendResult = rocketMQTemplate.syncSend(
                topic + ":tag1",
                MessageBuilder.withPayload(msgBody).build());
        System.out.println("sendResult--->>" + sendResult.getSendStatus());
    }

}
