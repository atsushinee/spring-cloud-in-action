package com.lichunorz.spring.fallback;

import com.lichunorz.spring.entity.User;
import com.lichunorz.spring.service.LocalHelloService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HelloServiceFallback implements LocalHelloService {

    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(@RequestParam("name") String name) {
        return "error";
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestParam("age") Integer age) {
        return new User("未知", 0);
    }

    @Override
    public String hello(@RequestBody() User user) {
        return "error";
    }
}
