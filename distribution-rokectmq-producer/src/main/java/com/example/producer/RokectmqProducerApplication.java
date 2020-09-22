package com.example.producer;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
public class RokectmqProducerApplication{

    public static void main(String[] args) {
        SpringApplication.run(RokectmqProducerApplication.class, args);
    }
}
