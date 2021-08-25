package com.didukh.routesservice.api;

import com.didukh.routesservice.controller.model.TrainModel;
import com.didukh.routesservice.group.OnCreate;
import com.didukh.routesservice.group.OnUpdate;
import com.didukh.routesservice.model.Train;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/trains")
public interface TrainApi {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    TrainModel getTrain(@PathVariable long id);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    TrainModel createTrain(@RequestBody @Validated(OnCreate.class) Train train);

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = "/{id}")
    TrainModel updateTrain(@PathVariable long id, @RequestBody @Validated(OnUpdate.class) Train train);

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    TrainModel deleteTrain(@PathVariable long id);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/getAllTrains")
    PagedModel<TrainModel> getAllTrains(Pageable pageable);
}
