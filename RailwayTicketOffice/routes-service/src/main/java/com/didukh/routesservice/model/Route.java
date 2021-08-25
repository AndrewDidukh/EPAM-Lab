package com.didukh.routesservice.model;

import com.didukh.routesservice.group.OnCreate;
import com.didukh.routesservice.group.OnUpdate;
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
    @OneToMany
    private List<Station> stations;
    @OneToMany
    private List<Train> trainId;
}
