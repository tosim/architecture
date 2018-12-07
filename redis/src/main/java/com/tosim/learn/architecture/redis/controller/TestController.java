package com.tosim.learn.architecture.redis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yaoyicheng
 * @data 2018/11/13 16:58
 */
@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/debug")
    public String testDebug() {
        logger.debug("this is debug");
        return "debug";
    }

    @GetMapping("/info")
    public String testInfo() {
        logger.info("this is info");
        return "debug";
    }

    @GetMapping("/warn")
    public String testWarn() {
        logger.warn("this is warn");
        return "warn";
    }

    @GetMapping("/errort")
    public String testError() {
        logger.error("this is error");
        return "error";
    }
}
