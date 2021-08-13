package com.didukh.service.repository;

import com.didukh.service.model.Activity;
import com.didukh.service.model.enums.ActivityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {
    Optional<Activity> findByActivityName(String activityName);

    Page<Activity> findAll(Pageable pageable);

    Page<Activity> findAllByActivityType(ActivityType activityType,Pageable pageable);

    Page<Activity> getUnacceptedActivities(Pageable pageable);

    boolean existsByActivityName(String ActivityName);
}
