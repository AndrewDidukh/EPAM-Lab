package com.didukh.service.test.util;


import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.AdminDto;
import com.didukh.service.dto.UserDto;
import com.didukh.service.model.Activity;
import com.didukh.service.model.Admin;
import com.didukh.service.model.User;
import com.didukh.service.model.enums.ActivityType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestDataUtil {

    public static final String FIRST_NAME = "FirstName";
    public static final String LAST_NAME = "LastName";
    public static final String TEST_EMAIL = "test@email.com";
    public static final String PASSWORD = "password";

    public static final String ACTIVITY_NAME = "testActivity";
    public static final Integer DURATION = 10;


    public static User createUser() {
        return User.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .email(TEST_EMAIL)
                .password(PASSWORD)
                .build();
    }

    public static UserDto createUserDto() {
        return UserDto.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .email(TEST_EMAIL)
                .password(PASSWORD)
                .repeatPassword(PASSWORD)
                .build();
    }

    public static Activity createActivity() {
        return Activity.builder()
                .activityName(ACTIVITY_NAME)
                .activityType(ActivityType.OTHER)
                .duration(null)
                .isAccepted(false)
                .build();
    }

    public static ActivityDto createActivityDto() {
        return ActivityDto.builder()
                .activityName(ACTIVITY_NAME)
                .activityType(ActivityType.OTHER)
                .duration(0)
                .isAccepted(false)
                .build();
    }

    public static Admin createAdmin() {
        return Admin.builder()
                .email(TEST_EMAIL)
                .password(PASSWORD)
                .build();
    }

    public static AdminDto createAdminDto() {
        return AdminDto.builder()
                .email(TEST_EMAIL)
                .password(PASSWORD)
                .repeatPassword(PASSWORD)
                .build();
    }
}
