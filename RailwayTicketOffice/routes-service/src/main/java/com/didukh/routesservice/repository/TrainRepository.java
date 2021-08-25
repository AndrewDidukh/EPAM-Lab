package com.didukh.routesservice.repository;


import com.didukh.routesservice.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TrainRepository extends JpaRepository<Train,Long> {
}
