package com.didukh.ticketsservice.controller.assembler;

import com.didukh.ticketsservice.controller.TicketController;
import com.didukh.ticketsservice.controller.model.TicketModel;
import com.didukh.ticketsservice.model.Ticket;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TicketAssembler extends RepresentationModelAssemblerSupport<Ticket, TicketModel> {
    public static final String GET_TICKET="get_ticket";
    public static final String ADD_TICKET="add_ticket";
    public static final String UPDATE_TICKET="update_ticket";
    public static final String DELETE_TICKET="delete_ticket";
    public static final String GET_ALL_TICKETS="get_all_tickets";

    public TicketAssembler() {super(TicketController.class,TicketModel.class);}


    @Override
    public TicketModel toModel(Ticket entity) {
        TicketModel ticketModel = new TicketModel(entity);
        Pageable page = PageRequest.of(0,10);

        Link get = linkTo(methodOn(TicketController.class).getTicket(entity.getId())).withRel(GET_TICKET);
        Link add = linkTo(methodOn(TicketController.class).createTicket(entity)).withRel(ADD_TICKET);
        Link update = linkTo(methodOn(TicketController.class).updateTicket(entity.getId(),entity)).withRel(UPDATE_TICKET);
        Link delete = linkTo(methodOn(TicketController.class).deleteTicket(entity.getId())).withRel(DELETE_TICKET);
        Link getAll= linkTo(methodOn(TicketController.class).getAllTickets(page)).withRel(GET_ALL_TICKETS);

        ticketModel.add(get,add,update,delete,getAll);
        return ticketModel;
    }
}
