package com.didukh.service.service;

import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.AdminDto;
import com.didukh.service.dto.UserDto;
import com.didukh.service.model.enums.ActivityType;


import java.util.List;

public interface AdminService {
    AdminDto createAdmin(AdminDto admin);

    AdminDto getAdmin(String email);

    ActivityDto acceptActivity(String email, String activityName);

    List<UserDto> getAllUsers();

    List<ActivityDto> getAllActivities();

    List<ActivityDto> getUnacceptedActivities();

    List<ActivityDto> getSortedActivitiesByName();

    List<ActivityDto> findAllByActivityType(ActivityType activityType);
}
