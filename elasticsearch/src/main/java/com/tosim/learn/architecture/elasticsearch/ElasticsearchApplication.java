package com.tosim.learn.architecture.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author yaoyicheng
 * @data 2018/12/13 10:00
 */
@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.tosim.learn.architecture.elasticsearch.es")
public class ElasticsearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class, args);
    }
}
