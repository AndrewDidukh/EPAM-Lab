package com.didukh.routesservice.service;

import com.didukh.routesservice.model.Route;
import com.didukh.routesservice.model.Station;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StationService {
    Station getStation(long id);

    Station addStation(Station station);

    Station updateStation(long id, Station station);

    void deleteStation(long id);

    Page<Station> getAllStations(Pageable pageable);
}
