package com.didukh.ticketsservice.api;

import com.didukh.ticketsservice.controller.model.TicketModel;
import com.didukh.ticketsservice.group.OnCreate;
import com.didukh.ticketsservice.group.OnUpdate;
import com.didukh.ticketsservice.model.Ticket;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/tickets")
public interface TicketApi {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    TicketModel getTicket(@PathVariable long id);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    TicketModel createTicket(@RequestBody @Validated(OnCreate.class) Ticket ticket);

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = "/{id}")
    TicketModel updateTicket(@PathVariable long id, @RequestBody @Validated(OnUpdate.class) Ticket ticket);

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    TicketModel deleteTicket(@PathVariable long id);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/getAllTickets")
    PagedModel<TicketModel> getAllTickets(Pageable pageable);
}
