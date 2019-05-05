package com.lichunorz.spring.service;

import com.lichunorz.api.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("micro-service")
public interface RefactorHelloService extends HelloService {
}
