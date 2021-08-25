package com.didukh.routesservice.controller;

import com.didukh.routesservice.api.TrainApi;
import com.didukh.routesservice.controller.assembler.RouteAssembler;
import com.didukh.routesservice.controller.assembler.TrainAssembler;
import com.didukh.routesservice.controller.model.TrainModel;
import com.didukh.routesservice.model.Route;
import com.didukh.routesservice.model.Train;
import com.didukh.routesservice.service.RouteService;
import com.didukh.routesservice.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TrainController implements TrainApi {

    private final TrainService trainService;
    private final TrainAssembler trainAssembler;
    private final PagedResourcesAssembler<Train> pagedResourcesAssembler;

    @Override
    public TrainModel getTrain(long id) {
        return trainAssembler.toModel(trainService.getTrain(id));
    }

    @Override
    public TrainModel createTrain(Train train) {
        return trainAssembler.toModel(trainService.addTrain(train));
    }

    @Override
    public TrainModel updateTrain(long id, Train train) {
        return trainAssembler.toModel(trainService.updateTrain(id,train));
    }

    @Override
    public TrainModel deleteTrain(long id) {
        trainService.deleteTrain(id);
        return new TrainModel();
    }

    @Override
    public PagedModel<TrainModel> getAllTrains(Pageable pageable) {
        return pagedResourcesAssembler.toModel(trainService.getAllTrains(pageable),trainAssembler);
    }
}
