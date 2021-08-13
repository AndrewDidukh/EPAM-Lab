package com.didukh.service.service;

import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.AdminActivityDto;
import com.didukh.service.dto.AdminDto;
import com.didukh.service.dto.UserDto;
import com.didukh.service.model.AdminActivity;
import com.didukh.service.model.enums.ActivityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;


import java.util.List;
import java.util.Optional;

public interface AdminService {
    AdminDto createAdmin(AdminDto admin);

    AdminDto getAdmin(String email);

    ActivityDto acceptActivity(String email, String activityName);

    Page<UserDto> getAllUsers(Pageable pageable);

    Page<AdminActivityDto> getAllActivities(Pageable pageable);

    Page<AdminActivityDto> getUnacceptedActivities(Pageable pageable);

    Page<AdminActivityDto> getSortedActivitiesByName(Pageable pageable);

    Page<AdminActivityDto> findAllByActivityType(ActivityType activityType,Pageable pageable);
}
