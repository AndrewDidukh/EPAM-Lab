package com.didukh.service.repository;

import com.didukh.service.model.Activity;
import com.didukh.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {
    Activity findByActivityName(String activityName);

    List<Activity> getUnacceptedActivities();

    List<Activity> findAll();

    boolean existsByActivityName(String ActivityName);
}
