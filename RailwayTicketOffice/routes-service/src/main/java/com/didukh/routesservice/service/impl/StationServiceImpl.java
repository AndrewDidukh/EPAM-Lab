package com.didukh.routesservice.service.impl;

import com.didukh.routesservice.model.Station;
import com.didukh.routesservice.repository.StationRepository;
import com.didukh.routesservice.service.StationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StationServiceImpl implements StationService {

    private final StationRepository stationRepository;

    @Override
    public Station getStation(long id) {
        log.info("getStation by id: {}", id);
        return stationRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Station addStation(Station station) {
        log.info("addStation");
        return stationRepository.save(station);
    }

    @Override
    public Station updateStation(long id, Station station) {
        log.info("updateStation for station with id: {}",id);
        Station persistedStation = stationRepository.findById(id).orElseThrow(RuntimeException::new);
        persistedStation.setStationName(station.getStationName());
        persistedStation.setArrivalTime(station.getArrivalTime());
        persistedStation.setGetOffTime(station.getGetOffTime());
        return stationRepository.save(persistedStation);
    }

    @Override
    public void deleteStation(long id) {
        log.info("deleteStation with id: {}",id);
        stationRepository.deleteById(id);
    }

    @Override
    public Page<Station> getAllStations(Pageable pageable) {
        log.info("getAllStations");
        return stationRepository.findAll(pageable);
    }
}
