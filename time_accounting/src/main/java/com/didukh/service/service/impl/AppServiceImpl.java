package com.didukh.service.service.impl;

import com.didukh.service.dto.AdminDto;
import com.didukh.service.exception.*;
import com.didukh.service.mapper.ActivityMapper;
import com.didukh.service.mapper.AdminMapper;
import com.didukh.service.mapper.UpdateMapping;
import com.didukh.service.mapper.UserMapper;
import com.didukh.service.model.Activity;
import com.didukh.service.model.Admin;
import com.didukh.service.model.User;
import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.UserDto;
import com.didukh.service.model.enums.ActivityType;
import com.didukh.service.repository.ActivityRepository;
import com.didukh.service.repository.AdminRepository;
import com.didukh.service.repository.UserRepository;
import com.didukh.service.service.AdminService;
import com.didukh.service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import java.util.Objects;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class AppServiceImpl implements UserService, AdminService {

    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final AdminRepository adminRepository;

    @Override
    public UserDto getUser(String email) {
        log.info("getUser by email {}", email);
        User user = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
        return UserMapper.INSTANCE.mapUserToUserDto(user);
    }

    @Override
    @Transactional
    public UserDto createUser(UserDto userDto) {
        log.info("createUser with email {}", userDto.getEmail());
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new UserAlreadyExistsException();
        }
        if (!Objects.equals(userDto.getPassword(), userDto.getRepeatPassword())) {
            throw new PasswordsAreNotTheSameException();
        }
        User user = UserMapper.INSTANCE.mapUserDtoToUser(userDto);
        user = userRepository.save(user);
        return UserMapper.INSTANCE.mapUserToUserDto(user);
    }

    @Override
    @Transactional
    public UserDto updateUser(String email, UserDto userDto) {
        log.info("updateUser with email {}", userDto.getEmail());
        User persistedUser = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
        UpdateMapping.populateUserWithPresentUserDtoFields(persistedUser, userDto);
        User storedUser = userRepository.save(persistedUser);
        return UserMapper.INSTANCE.mapUserToUserDto(storedUser);
    }

    @Override
    @Transactional
    public void deleteUser(String email) {
        log.info("deleteUser with email {}", email);
        User user = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }

    @Override
    public ActivityDto getActivity(String activityName) {
        log.info("getActivity by activityName {}", activityName);
        Activity activity = activityRepository.findByActivityName(activityName).orElseThrow(ActivityNotFoundException::new);
        return ActivityMapper.INSTANCE.mapActivityToActivityDto(activity);
    }

    @Override
    @Transactional
    public ActivityDto addActivityTime(String email, String activityName, Integer minutes) {
        log.info("addActivityTime by email {} , activityName {} with {} minutes", email, activityName, minutes);
        Activity persistedActivity = activityRepository.findByActivityName(activityName).orElseThrow(ActivityNotFoundException::new);
        if (!persistedActivity.isAccepted()) {
            throw new ActivityIsNotAcceptedException();
        }
        if (persistedActivity.getDuration() == null) {
            persistedActivity.setDuration(0);
        }
        persistedActivity.addDuration(minutes);
        activityRepository.save(persistedActivity);
        return ActivityMapper.INSTANCE.mapActivityToActivityDto(persistedActivity);
    }

    @Override
    @Transactional
    public ActivityDto createActivity(String email, ActivityDto activityDto) {
        log.info("createActivity for email {}", email);
        Activity activity = ActivityMapper.INSTANCE.mapActivityDtoToActivity(activityDto);
        if (!Arrays.stream(ActivityType.values()).collect(Collectors.toList()).contains(activity.getActivityType())) {
            throw new NoSuchActivityTypeException();
        }
        activity.setUser(userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new));
        activity = activityRepository.save(activity);
        return ActivityMapper.INSTANCE.mapActivityToActivityDto(activity);
    }


    @Override
    @Transactional
    public void deleteActivity(String email, String activityName) {
        log.info("deleteActivity for email {}", email);

        Activity activity = activityRepository.findByActivityName(activityName).orElseThrow(ActivityNotFoundException::new);
        activityRepository.delete(activity);
    }

    @Override
    @Transactional
    public AdminDto createAdmin(AdminDto adminDto) {
        log.info("createAdmin with email {}", adminDto.getEmail());
        if (adminRepository.existsByEmail(adminDto.getEmail())) {
            throw new AdminAlreadyExistsException();
        }
        if (!Objects.equals(adminDto.getPassword(), adminDto.getRepeatPassword())) {
            throw new PasswordsAreNotTheSameException();
        }
        Admin admin = AdminMapper.INSTANCE.mapAdminDtoToAdmin(adminDto);
        admin = adminRepository.save(admin);
        return AdminMapper.INSTANCE.mapAdminToAdminDto(admin);
    }

    @Override
    public AdminDto getAdmin(String email) {
        log.info("getAdmin by email {}", email);
        Admin admin = adminRepository.findByEmail(email).orElseThrow(AdminNotFoundException::new);
        return AdminMapper.INSTANCE.mapAdminToAdminDto(admin);
    }

    @Override
    @Transactional
    public ActivityDto acceptActivity(String email, String activityName) {
        log.info("acceptActivity {} for email {}", activityName, email);
        Activity activity = activityRepository.findByActivityName(activityName).orElseThrow(ActivityNotFoundException::new);
        activity.setAccepted(true);
        activityRepository.save(activity);
        return ActivityMapper.INSTANCE.mapActivityToActivityDto(activity);
    }

    @Override
    public List<ActivityDto> getAllActivities() {
        log.info("getAllActivities");
        List<Activity> activityMap;
        activityMap = activityRepository.findAll();
        return ActivityMapper.INSTANCE.mapActivityToActivityDtoInMap(activityMap);
    }

    @Override
    public List<ActivityDto> getUnacceptedActivities() {
        log.info("getUnacceptedActivities");
        Pageable pageWithTenElements = PageRequest.of(0, 10);
        List<Activity> activities = activityRepository.getUnacceptedActivities(pageWithTenElements);
        return ActivityMapper.INSTANCE.mapActivityToActivityDtoInMap(activities);
    }

    @Override
    public List<ActivityDto> getSortedActivitiesByName() {
        log.info("getUnacceptedActivities");
        List<Activity> activities = activityRepository.findAll(Sort.by("activityName"));
        return ActivityMapper.INSTANCE.mapActivityToActivityDtoInMap(activities);
    }

    @Override
    public List<ActivityDto> findAllByActivityType(ActivityType activityType) {
        log.info("findAllByActivityType");
        Pageable pageWithTenElements = PageRequest.of(0, 10);
        List<Activity> activities = activityRepository.findAllByActivityType(activityType, pageWithTenElements);
        return ActivityMapper.INSTANCE.mapActivityToActivityDtoInMap(activities);
    }


    @Override
    public List<UserDto> getAllUsers() {
        log.info("getAllUsers");
        List<User> users;
        users = userRepository.findAll();
        return UserMapper.INSTANCE.mapUsersToListDto(users);
    }


}
