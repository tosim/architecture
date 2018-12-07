package com.tosim.learn.architecture.redis.dao.domain;

import java.sql.Timestamp;

/**
 * @author yaoyicheng
 * @data 2018/11/12 16:31
 */
public class Ticket {

    private String ticketSeq;

    private Timestamp ticketDate;

    private String fromStation;

    private String toStation;

    private Integer ticketStock;

    public String getTicketSeq() {
        return ticketSeq;
    }

    public void setTicketSeq(String ticketSeq) {
        this.ticketSeq = ticketSeq;
    }

    public Timestamp getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(Timestamp ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public Integer getTicketStock() {
        return ticketStock;
    }

    public void setTicketStock(Integer ticketStock) {
        this.ticketStock = ticketStock;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketSeq='" + ticketSeq + '\'' +
                ", ticketDate=" + ticketDate +
                ", fromStation='" + fromStation + '\'' +
                ", toStation='" + toStation + '\'' +
                ", ticketStock=" + ticketStock +
                '}';
    }
}
