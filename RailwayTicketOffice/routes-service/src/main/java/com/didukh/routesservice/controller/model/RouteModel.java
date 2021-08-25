package com.didukh.routesservice.controller.model;

import com.didukh.routesservice.model.Route;
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
public class RouteModel extends RepresentationModel<RouteModel> {
    @JsonUnwrapped
    private Route route;
}

