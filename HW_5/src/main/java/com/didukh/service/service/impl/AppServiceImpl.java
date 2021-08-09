package com.didukh.service.service.impl;

import com.didukh.service.dto.AdminDto;
import com.didukh.service.exception.UserAlreadyExistsException;
import com.didukh.service.mapper.ActivityMapper;
import com.didukh.service.mapper.AdminMapper;
import com.didukh.service.mapper.UpdateMapping;
import com.didukh.service.mapper.UserMapper;
import com.didukh.service.model.Activity;
import com.didukh.service.model.Admin;
import com.didukh.service.model.User;
import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.UserDto;
import com.didukh.service.repository.ActivityRepository;
import com.didukh.service.repository.AdminRepository;
import com.didukh.service.repository.UserRepository;
import com.didukh.service.service.AdminService;
import com.didukh.service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;


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
        User user = userRepository.findByEmail(email);
        return UserMapper.INSTANCE.mapUserToUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("createUser with email {}", userDto.getEmail());
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new UserAlreadyExistsException();
        }
        User user = UserMapper.INSTANCE.mapUserDtoToUser(userDto);
        user = userRepository.save(user);
        return UserMapper.INSTANCE.mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        log.info("updateUser with email {}", userDto.getEmail());

        User persistedUser = userRepository.findByEmail(email);
        UpdateMapping.populateUserWithPresentUserDtoFields(persistedUser, userDto);
        User storedUser = userRepository.save(persistedUser);
        return UserMapper.INSTANCE.mapUserToUserDto(storedUser);
    }

    @Override
    public void deleteUser(String email) {
        log.info("deleteUser with email {}", email);
        User user = userRepository.findByEmail(email);
        userRepository.delete(user);
    }

    @Override
    public ActivityDto getActivity(String email, String activityName) {
        log.info("getActivity by email {} and activityName {}", email, activityName);
        Activity activity = activityRepository.findByActivityName(activityName);
        return ActivityMapper.INSTANCE.mapActivityToActivityDto(activity);
    }

    @Override
    public ActivityDto addActivityTime(String email, String activityName, int minutes) {
        log.info("addActivityTime by email {} , activityName {} with {} minutes", email, activityName, minutes);
        Activity activity = activityRepository.findByActivityName(activityName).addDuration(minutes);
        return ActivityMapper.INSTANCE.mapActivityToActivityDto(activity);
    }

    @Override
    public ActivityDto createActivity(String email, ActivityDto activityDto) {
        log.info("createActivity for email {}", email);
        Activity activity = ActivityMapper.INSTANCE.mapActivityDtoToActivity(activityDto);
        activity.setUser(userRepository.findByEmail(email));
        activity = activityRepository.save(activity);
        return ActivityMapper.INSTANCE.mapActivityToActivityDto(activity);
    }


    @Override
    public void deleteActivity(String email, String activityName) {
        log.info("deleteActivity for email {}", email);
        Activity activity = activityRepository.findByActivityName(activityName);
        activityRepository.delete(activity);
    }

    @Override
    public AdminDto createAdmin(AdminDto adminDto) {
        log.info("createAdmin with email {}", adminDto.getEmail());
        Admin admin = AdminMapper.INSTANCE.mapAdminDtoToAdmin(adminDto);
        admin = adminRepository.save(admin);
        return AdminMapper.INSTANCE.mapAdminToAdminDto(admin);
    }

    @Override
    public AdminDto getAdmin(String email) {
        log.info("getAdmin by email {}", email);
        Admin admin = adminRepository.findByEmail(email);
        return AdminMapper.INSTANCE.mapAdminToAdminDto(admin);
    }

    @Override
    public ActivityDto acceptActivity(String email, String activityName) {
        log.info("acceptActivity {} for email {}", activityName, email);

        Activity activity =activityRepository.findByActivityName(activityName);
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
        List<Activity> activities = activityRepository.getUnacceptedActivities();
        return ActivityMapper.INSTANCE.mapActivityToActivityDtoInMap(activities);
    }

    @Override
    public List<ActivityDto> getSortedActivitiesByName() {
        log.info("getUnacceptedActivities");
        List<Activity> activities = activityRepository.findAll(Sort.by("activityName"));
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
