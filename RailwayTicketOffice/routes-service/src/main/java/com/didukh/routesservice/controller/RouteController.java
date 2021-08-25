package com.didukh.routesservice.controller;

import com.didukh.routesservice.model.Route;
import com.didukh.routesservice.api.RouteApi;
import com.didukh.routesservice.controller.assembler.RouteAssembler;
import com.didukh.routesservice.controller.model.RouteModel;
import com.didukh.routesservice.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RouteController implements RouteApi {

    private final RouteService routeService;
    private final RouteAssembler routeAssembler;
    private final PagedResourcesAssembler<Route> pagedResourcesAssembler;

    @Override
    public RouteModel getRoute(long id) {
        return routeAssembler.toModel(routeService.getRoute(id));
    }

    @Override
    public RouteModel createRoute(Route route) {
        return routeAssembler.toModel(routeService.addRoute(route));
    }

    @Override
    public RouteModel updateRoute(long id, Route route) {
        return routeAssembler.toModel(routeService.updateRoute(id, route));
    }

    @Override
    public RouteModel deleteRoute(long id) {
        routeService.deleteRoute(id);
        return new RouteModel();
    }

    @Override
    public PagedModel<RouteModel> getAllRoutes(Pageable pageable) {
        return pagedResourcesAssembler.toModel(routeService.getAllRoutes(pageable),routeAssembler);
    }
}
