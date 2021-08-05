package com.didukh.service.service.impl;

import com.didukh.service.dto.AdminDto;
import com.didukh.service.mapper.ActivityMapper;
import com.didukh.service.mapper.AdminMapper;
import com.didukh.service.mapper.UserMapper;
import com.didukh.service.model.Activity;
import com.didukh.service.model.Admin;
import com.didukh.service.model.User;
import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.UserDto;
import com.didukh.service.repository.AppRepository;
import com.didukh.service.service.AdminService;
import com.didukh.service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Slf4j
@Service
@RequiredArgsConstructor
public class AppServiceImpl implements UserService, AdminService {

    private final AppRepository appRepository;

    @Override
    public UserDto getUser(String email) {
        log.info("getUser by email {}", email);
        User user = appRepository.getUser(email);
        return UserMapper.INSTANCE.mapUserToUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("createUser with email {}", userDto.getEmail());
        User user = UserMapper.INSTANCE.mapUserDtoToUser(userDto);
        user = appRepository.createUser(user);
        return UserMapper.INSTANCE.mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        log.info("updateUser with email {}", userDto.getEmail());
        User user = UserMapper.INSTANCE.mapUserDtoToUser(userDto);
        user = appRepository.updateUser(email, user);
        return UserMapper.INSTANCE.mapUserToUserDto(user);
    }

    @Override
    public void deleteUser(String email) {
        log.info("deleteUser with email {}", email);
        appRepository.deleteUser(email);
    }

    @Override
    public ActivityDto getActivity(String email, String activityName) {
        log.info("getActivity by email {} and activityName {}", email, activityName);
        Activity activity = appRepository.getActivity(email, activityName);
        return ActivityMapper.INSTANCE.mapActivityToActivityDto(activity);
    }

    @Override
    public ActivityDto addActivityTime(String email, String activityName, long seconds) {
        log.info("addActivityTime by email {} , activityName {} with {} seconds", email, activityName,seconds);
        Activity activity = appRepository.addActivityTime(email, activityName, seconds);
        return ActivityMapper.INSTANCE.mapActivityToActivityDto(activity);
    }

    @Override
    public ActivityDto createActivity(String email, ActivityDto activityDto) {
        log.info("createActivity for email {}", email);
        Activity activity = ActivityMapper.INSTANCE.mapActivityDtoToActivity(activityDto);
        activity = appRepository.createActivity(email,activity);
        return ActivityMapper.INSTANCE.mapActivityToActivityDto(activity);
    }

    @Override
    public ActivityDto updateActivity(String email, String activityName, ActivityDto activityDto) {
        log.info("updateActivity for email {} with activityName {}", email, activityName);
        Activity activity = ActivityMapper.INSTANCE.mapActivityDtoToActivity(activityDto);
        activity = appRepository.updateActivity(email, activityName, activity);
        return ActivityMapper.INSTANCE.mapActivityToActivityDto(activity);
    }

    @Override
    public void deleteActivity(String email, String activityName) {
        log.info("deleteActivity for email {}", email);
        appRepository.deleteActivity(email,activityName);
    }

    @Override
    public AdminDto createAdmin(AdminDto adminDto) {
        log.info("createAdmin with email {}", adminDto.getEmail());
        Admin admin = AdminMapper.INSTANCE.mapAdminDtoToAdmin(adminDto);
        admin = appRepository.createAdmin(admin);
        return AdminMapper.INSTANCE.mapAdminToAdminDto(admin);
    }

    @Override
    public AdminDto getAdmin(String email) {
        log.info("getAdmin by email {}", email);
        Admin admin = appRepository.getAdmin(email);
        return AdminMapper.INSTANCE.mapAdminToAdminDto(admin);
    }

    @Override
    public ActivityDto acceptActivity(String email, String activityName) {
        log.info("acceptActivity {} for email {}",activityName, email);
        Activity activity = appRepository.acceptActivity(email,activityName);
        return ActivityMapper.INSTANCE.mapActivityToActivityDto(activity);
    }

    @Override
    public Map<String, ActivityDto> getUnacceptedActivities() {
        log.info("getUnacceptedActivities");
        Map<String,Activity> activityMap;
        activityMap= appRepository.getUnacceptedActivities();
        return ActivityMapper.INSTANCE.mapActivityToActivityDtoInMap(activityMap);
    }

    @Override
    public List<UserDto> getAllUsers() {
        log.info("getUnacceptedActivities");
        List<User> users;
        users= appRepository.getAllUsers();
        return UserMapper.INSTANCE.mapUsersToListDto(users);
    }
}
