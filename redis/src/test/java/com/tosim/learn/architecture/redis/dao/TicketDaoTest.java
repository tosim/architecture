package com.tosim.learn.architecture.redis.dao;

import com.tosim.learn.architecture.redis.dao.domain.Ticket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yaoyicheng
 * @data 2018/11/12 16:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketDaoTest {

    @Autowired
    private TicketDao ticketDao;

    @Test
    public void getByTicketSeqTest() {
        Ticket ticket = ticketDao.getByTicketSeq("D396");
        System.out.println(ticket);
    }
}
