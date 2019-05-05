package com.lichunorz.spring.web;

import com.lichunorz.api.dto.User;
import com.lichunorz.api.service.HelloService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorHelloController implements HelloService {

    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    public User hello(@RequestHeader String name, @RequestHeader Integer age) {

        return new User(name, age);
    }

    public String hello(@RequestBody User user) {
        return "Hello " + user.getName() + ", " + user.getAge();
    }

}
