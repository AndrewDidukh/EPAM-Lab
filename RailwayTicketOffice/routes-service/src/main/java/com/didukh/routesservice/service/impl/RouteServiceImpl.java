package com.didukh.routesservice.service.impl;

import com.didukh.routesservice.model.Route;
import com.didukh.routesservice.repository.RouteRepository;
import com.didukh.routesservice.service.RouteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    @Override
    public Route getRoute(long id) {
        log.info("getRoute by id: {}",id);
        return routeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Route addRoute(Route route) {
        log.info("addRoute");
        return routeRepository.save(route);
    }

    @Override
    public Route updateRoute(long id,Route route) {
        log.info("updateRoute for route with id: {}",id);
        Route persistedRoute = routeRepository.findById(id).orElseThrow(RuntimeException::new);
        persistedRoute.setStations(route.getStations());
        persistedRoute.setTrainId(route.getTrainId());
        return routeRepository.save(persistedRoute);
    }

    @Override
    public void deleteRoute(long id) {
        log.info("deleteRoute with id: {}",id);
        routeRepository.deleteById(id);
    }

    @Override
    public Page<Route> getAllRoutes(Pageable pageable) {
        log.info("getAllRoutes");
        return routeRepository.findAll(pageable);
    }
}
