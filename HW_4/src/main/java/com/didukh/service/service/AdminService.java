package com.didukh.service.service;

import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.AdminDto;
import com.didukh.service.dto.UserDto;

import java.util.List;
import java.util.Map;

public interface AdminService {
    AdminDto createAdmin(AdminDto admin);

    AdminDto getAdmin(String email);

    ActivityDto acceptActivity(String email, String activityName);

    List<UserDto> getAllUsers();

    Map<String,ActivityDto> getUnacceptedActivities();
}
