package com.didukh.routesservice.api;

import com.didukh.routesservice.group.OnCreate;
import com.didukh.routesservice.group.OnUpdate;
import com.didukh.routesservice.model.Route;
import com.didukh.routesservice.controller.model.RouteModel;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/routes")
public interface RouteApi {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    RouteModel getRoute(@PathVariable long id);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    RouteModel createRoute(@RequestBody @Validated(OnCreate.class) Route route);

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = "/{id}")
    RouteModel updateRoute(@PathVariable long id, @RequestBody @Validated(OnUpdate.class) Route route);

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    RouteModel deleteRoute(@PathVariable long id);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/getAllRoutes")
    PagedModel<RouteModel> getAllRoutes(Pageable pageable);
}
