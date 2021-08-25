package com.didukh.ticketsservice.service.impl;

import com.didukh.ticketsservice.model.Ticket;
import com.didukh.ticketsservice.repository.TicketRepository;
import com.didukh.ticketsservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public Ticket getTicket(long id) {
        log.info("getTicket by id: {}",id);
        return ticketRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Ticket addTicket(Ticket ticket) {
        log.info("addTicket");
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket updateTicket(long id, Ticket ticket) {
        log.info("updateTicket for ticket with id: {}",id);
        Ticket persistedTicket = ticketRepository.findById(id).orElseThrow(RuntimeException::new);
        persistedTicket.setTrainId(ticket.getTrainId());
        persistedTicket.setFromStation(ticket.getFromStation());
        persistedTicket.setToStation(ticket.getToStation());
        persistedTicket.setArrivalTime(ticket.getArrivalTime());
        persistedTicket.setGetOffTime(ticket.getGetOffTime());
        persistedTicket.setPrice(ticket.getPrice());
        return ticketRepository.save(persistedTicket);
    }

    @Override
    public void deleteTicket(long id) {
        log.info("deleteTicket with id: {}",id);
        ticketRepository.deleteById(id);
    }

    @Override
    public Page<Ticket> getAllTickets(Pageable pageable) {
        log.info("getAllTickets");
        return ticketRepository.findAll(pageable);
    }
}
