package com.didukh.routesservice.controller.assembler;


import com.didukh.routesservice.controller.StationController;
import com.didukh.routesservice.controller.model.StationModel;
import com.didukh.routesservice.model.Station;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class StationAssembler extends RepresentationModelAssemblerSupport<Station, StationModel> {
    public static final String GET_STATION="get_station";
    public static final String ADD_STATION="add_station";
    public static final String UPDATE_STATION="update_station";
    public static final String DELETE_STATION="delete_station";
    public static final String GET_ALL_STATIONS="get_all_stations";

    public StationAssembler() {
        super(StationController.class,StationModel.class);
    }

    @Override
    public StationModel toModel(Station entity) {
        StationModel stationModel = new StationModel(entity);
        Pageable page = PageRequest.of(0,10);

        Link get = linkTo(methodOn(StationController.class).getStation(entity.getId())).withRel(GET_STATION);
        Link add = linkTo(methodOn(StationController.class).createStation(entity)).withRel(ADD_STATION);
        Link update = linkTo(methodOn(StationController.class).updateStation(entity.getId(),entity)).withRel(UPDATE_STATION);
        Link delete = linkTo(methodOn(StationController.class).deleteStation(entity.getId())).withRel(DELETE_STATION);
        Link getAll= linkTo(methodOn(StationController.class).getAllStations(page)).withRel(GET_ALL_STATIONS);

        stationModel.add(get,add,update,delete,getAll);
        return stationModel;
    }
}
