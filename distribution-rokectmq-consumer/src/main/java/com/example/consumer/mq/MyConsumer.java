package com.example.consumer.mq;

import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author tangxing
 * @Date 2020/9/15 16:43
 **/
@Service
@RocketMQMessageListener(topic = "mqTest", consumerGroup = "rocketmq-group", messageModel = MessageModel.BROADCASTING)
public class MyConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        System.out.println(System.currentTimeMillis() + " =====> MyConsumer received message: " + message);
    }
}
