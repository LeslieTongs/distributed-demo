package com.example.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author tangxing
 * @Date 2020/9/22 15:49
 **/

@RestController
@RequestMapping("/consume")
public class ConsumeController {

    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name){
       System.out.println("I'm calling nacos-consumer service by dynamic gateway...");
        return name + " Hi~, I'm from nacos-consumer";
    }

}
