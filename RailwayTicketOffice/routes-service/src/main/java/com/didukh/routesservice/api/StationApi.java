package com.didukh.routesservice.api;

import com.didukh.routesservice.controller.model.StationModel;
import com.didukh.routesservice.group.OnCreate;
import com.didukh.routesservice.group.OnUpdate;
import com.didukh.routesservice.model.Station;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/stations")
public interface StationApi {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    StationModel getStation(@PathVariable long id);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    StationModel createStation(@RequestBody @Validated(OnCreate.class) Station station);

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = "/{id}")
    StationModel updateStation(@PathVariable long id, @RequestBody @Validated(OnUpdate.class) Station station);

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    StationModel deleteStation(@PathVariable long id);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/getAllStations")
    PagedModel<StationModel> getAllStations(Pageable pageable);

}
