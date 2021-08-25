package com.didukh.ticketsservice.controller.model;

import com.didukh.ticketsservice.model.Ticket;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class TicketModel extends RepresentationModel<TicketModel> {
    @JsonUnwrapped
    private Ticket ticket;
}
