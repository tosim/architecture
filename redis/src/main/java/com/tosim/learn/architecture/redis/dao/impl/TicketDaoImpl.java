package com.tosim.learn.architecture.redis.dao.impl;

import com.tosim.learn.architecture.redis.dao.TicketDao;
import com.tosim.learn.architecture.redis.dao.domain.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author yaoyicheng
 * @data 2018/11/12 16:53
 */
@Repository
public class TicketDaoImpl implements TicketDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Ticket getByTicketSeq(String ticketSeq) {
        return jdbcTemplate.queryForObject("select * from tb_ticket where ticket_seq = ?",
            new Object[] {ticketSeq},
            new BeanPropertyRowMapper<>(Ticket.class)
        );
    }
}
