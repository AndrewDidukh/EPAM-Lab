package com.didukh.routesservice.controller;

import com.didukh.routesservice.api.StationApi;
import com.didukh.routesservice.controller.assembler.StationAssembler;
import com.didukh.routesservice.controller.model.StationModel;
import com.didukh.routesservice.model.Station;
import com.didukh.routesservice.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StationController implements StationApi {

    private final StationService stationService;
    private final StationAssembler stationAssembler;
    private final PagedResourcesAssembler<Station> pagedResourcesAssembler;

    @Override
    public StationModel getStation(long id) {
        return stationAssembler.toModel(stationService.getStation(id));
    }

    @Override
    public StationModel createStation(Station station) {
        return stationAssembler.toModel(stationService.addStation(station));
    }

    @Override
    public StationModel updateStation(long id, Station station) {
        return stationAssembler.toModel(stationService.updateStation(id,station));
    }

    @Override
    public StationModel deleteStation(long id) {
        stationService.deleteStation(id);
        return new StationModel();
    }

    @Override
    public PagedModel<StationModel> getAllStations(Pageable pageable) {
        return pagedResourcesAssembler.toModel(stationService.getAllStations(pageable),stationAssembler);
    }
}
