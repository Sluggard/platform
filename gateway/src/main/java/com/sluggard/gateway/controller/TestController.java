package com.sluggard.gateway.controller;

import com.sluggard.interfaces.test.TestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestController {

    @Reference
    private TestService testService;

    @GetMapping("/test")
    public Mono<String> test(){
        return Mono.just(testService.test());
    }

}
