package com.didukh.ticketsservice.service;

import com.didukh.ticketsservice.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {
    Ticket getTicket(long id);

    Ticket addTicket(Ticket ticket);

    Ticket updateTicket(long id, Ticket ticket);

    void deleteTicket(long id);

    Page<Ticket> getAllTickets(Pageable pageable);
}
