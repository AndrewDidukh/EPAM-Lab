package com.didukh.ticketsservice.model;

import com.didukh.ticketsservice.group.OnCreate;
import com.didukh.ticketsservice.group.OnUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Null(message = "id must be absent in request",groups = {OnCreate.class, OnUpdate.class})
    private long id;
    private long trainId;
    private String fromStation;
    private String toStation;
    private LocalDateTime getOffTime;
    private LocalDateTime arrivalTime;
    private double price;
    private boolean isBought;
}
