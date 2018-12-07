package com.tosim.learn.architecture.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author yaoyicheng
 * @data 2018/11/12 15:10
 */
@SpringBootApplication(exclude = {
        RedisAutoConfiguration.class,
        RedisRepositoriesAutoConfiguration.class,
        DataSourceAutoConfiguration.class
})
public class RedisApplication {
    private static final Logger logger = LoggerFactory.getLogger(RedisApplication.class);

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(RedisApplication.class, args);
        for (int i = 0; i < 100000; i++) {
            Thread.sleep(500);
            logger.trace("trace");
            Thread.sleep(500);
            logger.debug("debug");
            Thread.sleep(500);
            logger.info("info");
            Thread.sleep(500);
            logger.warn("warn");
            Thread.sleep(500);
            logger.error("error");
            Thread.sleep(500);
            logger.info("done");
        }
    }
}
