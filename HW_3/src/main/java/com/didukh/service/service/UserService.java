package com.didukh.service.service;

import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.UserDto;

public interface UserService {

    UserDto getUser(String email);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(String email, UserDto user);

    void deleteUser(String email);

    ActivityDto getActivity(String email, String activityName);

    ActivityDto updateActivity(String email, String activityName, ActivityDto activityDto);

    ActivityDto createActivity(String email, ActivityDto activityDto);

    void deleteActivity(String email,String activityName);
}
