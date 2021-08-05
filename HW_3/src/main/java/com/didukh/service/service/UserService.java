package com.didukh.service.service;

import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.UserDto;
import com.didukh.service.model.Activity;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUser(String email);

    void deleteUser(String email);

    ActivityDto getActivity(String email, String activityName);

    ActivityDto addActivityTime(String email, String activityName, long seconds);

    ActivityDto createActivity(String email, ActivityDto activityDto);

    void deleteActivity(String email,String activityName);
}
