package com.didukh.routesservice.controller;

import com.didukh.routesservice.api.TrainApi;
import com.didukh.routesservice.controller.assembler.RouteAssembler;
import com.didukh.routesservice.controller.model.TrainModel;
import com.didukh.routesservice.model.Route;
import com.didukh.routesservice.model.Train;
import com.didukh.routesservice.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;

@RequiredArgsConstructor
public class TrainController implements TrainApi {

    private final RouteService routeService;
    private final RouteAssembler routeAssembler;
    private final PagedResourcesAssembler<Route> pagedResourcesAssembler;

    @Override
    public TrainModel getTrain(long id) {
        return null;
    }

    @Override
    public TrainModel createTrain(Train train) {
        return null;
    }

    @Override
    public TrainModel updateTrain(long id, Train train) {
        return null;
    }

    @Override
    public TrainModel deleteTrain(long id) {
        return null;
    }

    @Override
    public PagedModel<TrainModel> getAllTrains(Pageable pageable) {
        return null;
    }
}
