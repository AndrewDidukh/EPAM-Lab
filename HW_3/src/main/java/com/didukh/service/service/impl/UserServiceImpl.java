package com.didukh.service.service.impl;

import com.didukh.service.mapper.ActivityMapper;
import com.didukh.service.mapper.UserMapper;
import com.didukh.service.model.Activity;
import com.didukh.service.model.User;
import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.UserDto;
import com.didukh.service.repository.UserRepository;
import com.didukh.service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
//    private final ActivityMapper activityMapper;
//    private final UserMapper userMapper;

    @Override
    public UserDto getUser(String email) {
        log.info("getUser by email {}", email);
        User user = userRepository.getUser(email);
        return UserMapper.INSTANCE.mapUserToUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("createUser with email {}", userDto.getEmail());
        User user = UserMapper.INSTANCE.mapUserDtoToUser(userDto);
        user = userRepository.createUser(user);
        return UserMapper.INSTANCE.mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        log.info("updateUser with email {}", userDto.getEmail());
        User user = UserMapper.INSTANCE.mapUserDtoToUser(userDto);
        user = userRepository.updateUser(email, user);
        return UserMapper.INSTANCE.mapUserToUserDto(user);
    }

    @Override
    public void deleteUser(String email) {
        log.info("deleteUser with email {}", email);
        userRepository.deleteUser(email);
    }

    @Override
    public ActivityDto getActivity(String email, String activityName) {
        log.info("getActivity by email {} and activityName {}", email, activityName);
        Activity activity = userRepository.getActivity(email, activityName);
        return ActivityMapper.INSTANCE.mapActivityToActivityDto(activity);
    }

    @Override
    public ActivityDto createActivity(String email, ActivityDto activityDto) {
        log.info("createActivity for email {}", email);
        Activity activity = ActivityMapper.INSTANCE.mapActivityDtoToActivity(activityDto);
        activity = userRepository.createActivity(email,activity);
        return ActivityMapper.INSTANCE.mapActivityToActivityDto(activity);
    }

    @Override
    public ActivityDto updateActivity(String email, String activityName, ActivityDto activityDto) {
        log.info("updateActivity for email {} with activityName {}", email, activityName);
        Activity activity = ActivityMapper.INSTANCE.mapActivityDtoToActivity(activityDto);
        activity = userRepository.updateActivity(email, activityName, activity);
        return ActivityMapper.INSTANCE.mapActivityToActivityDto(activity);
    }

    @Override
    public void deleteActivity(String email, String activityName) {
        log.info("deleteActivity for email {}", email);
        userRepository.deleteActivity(email,activityName);
    }


//    private UserDto mapUserToUserDto(User user) {
//        return UserDto.builder()
//                .firstName(user.getFirstName())
//                .lastName(user.getLastName())
//                .email(user.getEmail())
//                .activities(user.getActivities())
//                .build();
//    }
//
//    private User mapUserDtoToUser(UserDto userDto) {
//        return User.builder()
//                .firstName(userDto.getFirstName())
//                .lastName(userDto.getLastName())
//                .email(userDto.getEmail())
//                .password(userDto.getPassword())
//                .activities(userDto.getActivities())
//                .build();
//    }

//    private ActivityDto mapActivityToActivityDto(Activity activity) {
//        return ActivityDto.builder()
//                .activityName(activity.getActivityName())
//                .duration(activity.getDuration())
//                .build();
//    }
//
//    private Activity mapActivityDtoToActivity(ActivityDto activityDto) {
//        return Activity.builder()
//                .activityName(activityDto.getActivityName())
//                .duration(activityDto.getDuration())
//                .build();
//    }
}
