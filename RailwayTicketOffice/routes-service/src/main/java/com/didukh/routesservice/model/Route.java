package com.didukh.routesservice.model;

import com.didukh.routesservice.group.OnCreate;
import com.didukh.routesservice.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Null(message = "id must be absent in request",groups = {OnCreate.class, OnUpdate.class})
    private long id;
    @JsonManagedReference
    @OneToMany
    private List<Station> stations;
    @JsonManagedReference
    @OneToMany
    private List<Train> trainId;
}
