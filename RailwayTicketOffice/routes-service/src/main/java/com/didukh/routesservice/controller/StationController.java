package com.didukh.routesservice.controller;

import com.didukh.routesservice.api.StationApi;
import com.didukh.routesservice.controller.assembler.RouteAssembler;
import com.didukh.routesservice.controller.model.StationModel;
import com.didukh.routesservice.model.Route;
import com.didukh.routesservice.model.Station;
import com.didukh.routesservice.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;

@RequiredArgsConstructor
public class StationController implements StationApi {

    private final RouteService routeService;
    private final RouteAssembler routeAssembler;
    private final PagedResourcesAssembler<Route> pagedResourcesAssembler;

    @Override
    public StationModel getStation(long id) {
        return null;
    }

    @Override
    public StationModel createStation(Station station) {
        return null;
    }

    @Override
    public StationModel updateStation(long id, Station station) {
        return null;
    }

    @Override
    public StationModel deleteStation(long id) {
        return null;
    }

    @Override
    public PagedModel<StationModel> getAllStations(Pageable pageable) {
        return null;
    }
}
