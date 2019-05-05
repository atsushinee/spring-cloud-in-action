package com.lichunorz.spring.web;

import com.lichunorz.spring.entity.User;
import com.lichunorz.spring.service.LocalHelloService;
import com.lichunorz.spring.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    LocalHelloService localHelloService;
    @Autowired
    RefactorHelloService refactorHelloService;

    @GetMapping("/feign-consumer")
    public String helloConsumer() {
        return localHelloService.hello();
    }

    @GetMapping("/feign-consumer2")
    public String helloConsumer2() {
        return localHelloService.hello() + "\n" +
                localHelloService.hello("micro-service") + "\n" +
                localHelloService.hello("micro-service", 23) + "\n" +
                localHelloService.hello(new User("micro-service", 23)) + "\n";
    }

    @GetMapping("/feign-consumer3")
    public String helloConsumer3() {
        return refactorHelloService.hello("micro-service") + "\n" +
                refactorHelloService.hello("micro-service", 23) + "\n" +
                refactorHelloService.hello(new com.lichunorz.api.dto.User("micro-service", 23)) + "\n";
    }
}
