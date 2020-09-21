package com.example.consumer;

import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * @Description TODO
 * @Author tangxing
 * @Date 2020/9/15 16:43
 **/
@Service
@RocketMQMessageListener(topic = "mqTest", consumerGroup = "rocketmq-group", messageModel = MessageModel.BROADCASTING)
public class MyConsumer2 implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        System.out.println(System.currentTimeMillis() + " =====> MyConsumer2 received message: " + message);
    }

    public static void main(String[] args) {
        TreeMap<BigDecimal, BigDecimal> treeMap = new TreeMap<BigDecimal, BigDecimal>();
        treeMap.put(new BigDecimal("1"), new BigDecimal("1"));
        treeMap.put(new BigDecimal("0.5"), new BigDecimal("0.5"));
        System.out.println(treeMap);
    }


}
