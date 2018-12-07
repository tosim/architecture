package com.tosim.learn.architecture.redis.service;

import com.tosim.learn.architecture.redis.dao.TicketDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author yaoyicheng
 * @data 2018/11/12 16:51
 */
@Service
public class TicketService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private TicketDao ticketDao;

    public Integer queryTicketStock(String ticketSeq) {
        // 1.读缓存
        String value = redisTemplate.opsForValue().get(ticketSeq);
        if(!StringUtils.isEmpty(value)) {
            return Integer.parseInt(value);
        }
        // 2.缓存中没有，读数据库
        value = ticketDao.getByTicketSeq(ticketSeq).getTicketStock().toString();

        // 3.设置缓存
        redisTemplate.opsForValue().set(ticketSeq, value, 10, TimeUnit.SECONDS);
        return Integer.parseInt(value);
    }
}
