package com.didukh.routesservice.controller.assembler;

import com.didukh.routesservice.controller.RouteController;
import com.didukh.routesservice.model.Route;

import com.didukh.routesservice.controller.model.RouteModel;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Component
public class RouteAssembler extends RepresentationModelAssemblerSupport<Route, RouteModel>{
    public static final String GET_ROUTE="get_route";
    public static final String ADD_ROUTE="add_route";
    public static final String UPDATE_ROUTE="update_route";
    public static final String DELETE_ROUTE="delete_route";
    public static final String GET_ALL_ROUTES="get_all_routes";

    public RouteAssembler() {super(RouteController.class,RouteModel.class);}

    @Override
    public RouteModel toModel(Route entity) {
        RouteModel routeModel = new RouteModel(entity);
        Pageable page = PageRequest.of(0,10);

        Link get = linkTo(methodOn(RouteController.class).getRoute(entity.getId())).withRel(GET_ROUTE);
        Link add = linkTo(methodOn(RouteController.class).createRoute(entity)).withRel(ADD_ROUTE);
        Link update = linkTo(methodOn(RouteController.class).updateRoute(entity.getId(),entity)).withRel(UPDATE_ROUTE);
        Link delete = linkTo(methodOn(RouteController.class).deleteRoute(entity.getId())).withRel(DELETE_ROUTE);
        Link getAll= linkTo(methodOn(RouteController.class).getAllRoutes(page)).withRel(GET_ALL_ROUTES);

        routeModel.add(get,add,update,delete,getAll);
        return routeModel;
    }
}
