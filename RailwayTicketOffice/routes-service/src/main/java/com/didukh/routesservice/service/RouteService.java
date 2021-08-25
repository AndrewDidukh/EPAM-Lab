package com.didukh.routesservice.service;

import com.didukh.routesservice.model.Route;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RouteService {
    Route getRoute(long id);

    Route addRoute(Route route);

    Route updateRoute(long id, Route route);

    void deleteRoute(long id);

    Page<Route> getAllRoutes(Pageable pageable);
}
