package com.didukh.routesservice.service;

import com.didukh.routesservice.model.Route;
import com.didukh.routesservice.model.Train;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TrainService {
    Train getTrain(long id);

    Train addTrain(Train train);

    Train updateTrain(long id,Train train);

    void deleteTrain(long id);

    Page<Train> getAllTrains(Pageable pageable);
}
