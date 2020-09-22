package com.example.producer.controller;

import com.example.producer.message.MessageData;
import com.example.producer.message.RokectMqMessage;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author tangxing
 * @Date 2020/9/15 17:50
 **/

@RestController
@RequestMapping("/mq")
public class RokectMqController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/send")
    public void send(){
        rocketMQTemplate.convertAndSend("mqTest", "Hello, World! I'm from convertAndSend message");
        rocketMQTemplate.send("mqTest", MessageBuilder.withPayload("Hello, World! I'm from spring message").build());
    }

    @GetMapping("/syncSend")
    public void syncSend(){
        rocketMQTemplate.syncSend("mqTest", "Hello, World! I'm from simple message", System.currentTimeMillis());
    }

    @GetMapping("/delaySyncSend")
    public void delaySyncSend(){
        MessageData messageData = new MessageData();
        messageData.setKey(String.valueOf(System.currentTimeMillis()));
        messageData.setContent("I'm from RokectMqMessage Message");
        RokectMqMessage rokectMqMessage = new RokectMqMessage(messageData);
         // 发送延迟消息
        rocketMQTemplate.syncSend("mqTest", rokectMqMessage, System.currentTimeMillis(), 2);
    }

    @GetMapping("/orderlySyncSend")
    public void orderlySyncSend(){
        // 发送顺序消息
        rocketMQTemplate.syncSendOrderly("mqTest", "I'm order message", "1234");
    }

}
