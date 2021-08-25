package com.didukh.ticketsservice.controller;

import com.didukh.ticketsservice.api.TicketApi;
import com.didukh.ticketsservice.controller.assembler.TicketAssembler;
import com.didukh.ticketsservice.controller.model.TicketModel;
import com.didukh.ticketsservice.model.Ticket;
import com.didukh.ticketsservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TicketController implements TicketApi {

    private final TicketService ticketService;
    private final TicketAssembler ticketAssembler;
    private final PagedResourcesAssembler<Ticket> pagedResourcesAssembler;

    @Override
    public TicketModel getTicket(long id) {
        return ticketAssembler.toModel(ticketService.getTicket(id));
    }

    @Override
    public TicketModel createTicket(Ticket ticket) {
        return ticketAssembler.toModel(ticketService.addTicket(ticket));
    }

    @Override
    public TicketModel updateTicket(long id, Ticket ticket) {
        return ticketAssembler.toModel(ticketService.updateTicket(id, ticket));
    }

    @Override
    public TicketModel deleteTicket(long id) {
        ticketService.deleteTicket(id);
        return new TicketModel();
    }

    @Override
    public PagedModel<TicketModel> getAllTickets(Pageable pageable) {
        return pagedResourcesAssembler.toModel(ticketService.getAllTickets(pageable),ticketAssembler);
    }
}
