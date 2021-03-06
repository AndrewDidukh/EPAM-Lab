package com.didukh.service.service;

import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.UserActivityDto;
import com.didukh.service.dto.UserDto;
import com.didukh.service.model.Activity;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUser(String email);

    void deleteUser(String email);

    UserDto updateUser(String email, UserDto user);

    UserActivityDto getActivity(String email, String activityName);

    UserActivityDto addActivityTime(String email, String activityName, Integer minutes);

    UserActivityDto createActivity(String email, ActivityDto activityDto);

    void deleteActivity(String email, String activityName);

}
