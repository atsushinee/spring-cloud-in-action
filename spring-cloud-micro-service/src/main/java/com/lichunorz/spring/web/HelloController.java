package com.lichunorz.spring.web;

import com.lichunorz.spring.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@Slf4j
public class HelloController {

    @Autowired
    private DiscoveryClient client;
    @Value("${spring.application.name}")
    private String serviceId;

    @RequestMapping("/hello")
    public String index() throws InterruptedException {
        ServiceInstance instance = client.getInstances(serviceId).get(0);

        int sleepTime = new Random().nextInt(3000);
        log.info("sleepTime:" + sleepTime);
        Thread.sleep(sleepTime);
        log.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());


        return "Hello World";
    }


    @GetMapping("/hello1")
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    @GetMapping("/hello2")
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {

        return new User(name, age);
    }

    @PostMapping("/hello3")
    public String hello(@RequestBody User user) {
        return "Hello " + user.getName() + ", " + user.getAge();
    }
}
