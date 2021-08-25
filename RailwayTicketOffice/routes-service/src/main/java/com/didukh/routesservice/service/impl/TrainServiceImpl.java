package com.didukh.routesservice.service.impl;

import com.didukh.routesservice.model.Station;
import com.didukh.routesservice.model.Train;
import com.didukh.routesservice.repository.TrainRepository;
import com.didukh.routesservice.service.TrainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrainServiceImpl implements TrainService {

    private final TrainRepository trainRepository;

    @Override
    public Train getTrain(long id) {
        log.info("getTrain by id: {}", id);
        return trainRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Train addTrain(Train train) {
        log.info("addTrain");
        return trainRepository.save(train);
    }

    @Override
    public Train updateTrain(long id,Train train) {
        log.info("updateTrain for train with id: {}",id);
        Train persistedTrain = trainRepository.findById(id).orElseThrow(RuntimeException::new);
        persistedTrain.setAllSeatsCount(train.getAllSeatsCount());
        persistedTrain.setPrice(train.getPrice());
        persistedTrain.setAvailableSeatsCount(train.getAvailableSeatsCount());
        return trainRepository.save(persistedTrain);
    }

    @Override
    public void deleteTrain(long id) {
        log.info("deleteTrain with id: {}",id);
        trainRepository.deleteById(id);
    }

    @Override
    public Page<Train> getAllTrains(Pageable pageable) {
        log.info("getAllTrains");
        return trainRepository.findAll(pageable);
    }
}
