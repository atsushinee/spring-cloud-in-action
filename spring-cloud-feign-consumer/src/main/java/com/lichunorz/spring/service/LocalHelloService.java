package com.lichunorz.spring.service;

import com.lichunorz.spring.entity.User;
import com.lichunorz.spring.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "micro-service", fallback = HelloServiceFallback.class)
public interface LocalHelloService {
    @RequestMapping("/hello")
    String hello();

    @GetMapping("/hello1")
    String hello(@RequestParam("name") String name);

    @GetMapping("/hello2")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @PostMapping("/hello3")
    String hello(@RequestBody User user);
}
