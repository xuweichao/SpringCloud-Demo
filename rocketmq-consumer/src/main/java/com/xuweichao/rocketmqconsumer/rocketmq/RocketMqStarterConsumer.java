package com.xuweichao.rocketmqconsumer.rocketmq;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * rocketmq 消息监听，@RocketMQMessageListener中的selectorExpression为tag，默认为*
 */
@Component
@RocketMQMessageListener(
        topic = "${rocketmq.consumer.topic}",
        consumerGroup = "${rocketmq.consumer.group}"
        )
public class RocketMqStarterConsumer implements RocketMQListener<MessageExt> {

    @Override
    public void onMessage(MessageExt message) {
        byte[] body = message.getBody();
        String msg = new String(body);
        System.out.println("接收到消息：-->>"+msg);
    }
}
