package com.sluggard.user.service.impl;

import com.sluggard.interfaces.test.TestService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String test() {
        return "hello world!";
    }
}

