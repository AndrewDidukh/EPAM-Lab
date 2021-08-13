package com.didukh.service.service;

import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.AdminActivityDto;
import com.didukh.service.dto.AdminDto;
import com.didukh.service.dto.UserDto;
import com.didukh.service.model.AdminActivity;
import com.didukh.service.model.enums.ActivityType;


import java.util.List;
import java.util.Optional;

public interface AdminService {
    AdminDto createAdmin(AdminDto admin);

    AdminDto getAdmin(String email);

    ActivityDto acceptActivity(String email, String activityName);

    List<UserDto> getAllUsers();

    List<AdminActivityDto> getAllActivities();

    List<AdminActivityDto> getUnacceptedActivities();

    List<AdminActivityDto> getSortedActivitiesByName();

    List<AdminActivityDto> findAllByActivityType(ActivityType activityType);
}
