package com.didukh.routesservice.model;

import com.didukh.routesservice.group.OnCreate;
import com.didukh.routesservice.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Null;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Null(message = "id must be absent in request",groups = {OnCreate.class, OnUpdate.class})
    private long id;
    private double price;
    private int allSeatsCount;
    private int availableSeatsCount;
    @ManyToOne()
    @JsonBackReference
    private Route route;
}
