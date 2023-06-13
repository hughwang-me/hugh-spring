package com.hugh.spring.controller;

import com.hugh.spring.common.Result;
import com.hugh.spring.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping(value = "test")
public class TestController {

    @Resource
    TestService testService;

    @GetMapping(value = "list")
    public Result<Object> list(){
        log.warn("TestController -> list ");
        return Result.ok(testService.lis());
    }
}
