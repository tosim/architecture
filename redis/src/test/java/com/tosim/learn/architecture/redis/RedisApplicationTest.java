package com.tosim.learn.architecture.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

/**
 * @author yaoyicheng
 * @data 2018/11/12 15:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void redisSetTest() {
        redisTemplate.opsForValue().set("yyc", "good", 10, TimeUnit.MILLISECONDS);
    }

    @Test
    public void redisGetTest() {
        String value = redisTemplate.opsForValue().get("yyc");
        System.out.println(value);
    }

    @Test
    public void jdbcSetTest() {
        try {
            int row = jdbcTemplate.update("INSERT INTO tb_ticket (ticket_seq, ticket_date, from_station, to_station, ticket_stock) VALUES (?, ?, ?, ?, ?)",
                    "D396",
                    new Timestamp(System.currentTimeMillis()),
                    "杭州东",
                    "绍兴东",
                    100
            );
            System.out.println(row);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void instanceOfTest() {
        class A {}
        class B extends A {}
        A a = new A();
        B b = new B();
        System.out.println(b instanceof A);
        System.out.println(b instanceof Object);
        System.out.println(a instanceof A);
        System.out.println(B.class.isInstance(a));
    }
}

