package com.example.producer.controller;

/**
 * @Description TODO
 * @Author tangxing
 * @Date 2020/9/22 15:48
 **/

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provide/")
public class ProviderController {

    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name){
        System.out.println("I'm calling nacos-provider service by dynamic gateway...");
        return name + " Hi~, I'm from nacos-provider";
    }

}
