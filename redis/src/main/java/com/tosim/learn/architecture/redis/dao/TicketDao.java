package com.tosim.learn.architecture.redis.dao;

import com.tosim.learn.architecture.redis.dao.domain.Ticket;

/**
 * @author yaoyicheng
 * @data 2018/11/12 16:52
 */
public interface TicketDao {

    Ticket getByTicketSeq(String ticketSeq);
}
