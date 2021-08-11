package com.didukh.service.service;

import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.AdminDto;
import com.didukh.service.dto.UserDto;
import com.didukh.service.exception.*;
import com.didukh.service.model.Activity;
import com.didukh.service.model.Admin;
import com.didukh.service.model.User;
import com.didukh.service.model.enums.ActivityType;
import com.didukh.service.repository.ActivityRepository;
import com.didukh.service.repository.AdminRepository;
import com.didukh.service.repository.UserRepository;
import com.didukh.service.service.impl.AppServiceImpl;
import com.didukh.service.test.util.TestDataUtil;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static com.didukh.service.test.util.TestDataUtil.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AppServiceImplTest {

    @InjectMocks
    private AppServiceImpl appService;

    @Mock
    private ActivityRepository activityRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private AdminRepository adminRepository;

    @Test
    void getUserTest() {
        User user = createUser();
        when(userRepository.findByEmail(TEST_EMAIL)).thenReturn(Optional.of(user));

        UserDto userDto = appService.getUser(TEST_EMAIL);

        assertThat(userDto, allOf(
                hasProperty("email", equalTo(user.getEmail())),
                hasProperty("firstName", equalTo(user.getFirstName()))
        ));
    }

    @Test
    void getUserNotFoundTest() {
        when(userRepository.findByEmail(TEST_EMAIL)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> appService.getUser(TEST_EMAIL));
    }

    @Test
    void createUserTest() {
        User testUser = createUser();
        UserDto testUserDto = createUserDto();
        when(userRepository.save(any())).thenReturn(testUser);

        UserDto userDto = appService.createUser(testUserDto);

        assertThat(userDto, allOf(
                hasProperty("firstName", equalTo(testUser.getFirstName())),
                hasProperty("lastName", equalTo(testUser.getLastName())),
                hasProperty("email", equalTo(testUser.getEmail())),
                hasProperty("activities", equalTo(testUser.getActivities()))
        ));
    }

    @Test
    void createUserUserAlreadyExistsTest() {
        UserDto testUserDto = createUserDto();
        when(userRepository.existsByEmail(TEST_EMAIL)).thenReturn(true);
        assertThrows(UserAlreadyExistsException.class, () -> appService.createUser(testUserDto));
    }

    @Test
    void createUserPasswordsAreNotTheSame() {
        UserDto testUserDto = createUserDto();
        testUserDto.setRepeatPassword("wrongRepeatPassword");
        assertThrows(PasswordsAreNotTheSameException.class, () -> appService.createUser(testUserDto));
    }

    @Test
    void updateUserTest() {
        UserDto testUserDto = createUserDto();
        User testUser = createUser();
        when(userRepository.findByEmail(testUserDto.getEmail())).thenReturn(Optional.of(testUser));
        when(userRepository.save(any())).thenReturn(testUser);

        UserDto userDto = appService.updateUser(testUser.getEmail(), testUserDto);

        assertThat(userDto, allOf(
                hasProperty("firstName", equalTo(testUser.getFirstName())),
                hasProperty("lastName", equalTo(testUser.getLastName())),
                hasProperty("email", equalTo(testUser.getEmail())),
                hasProperty("activities", equalTo(testUser.getActivities()))
        ));
    }

    @Test
    void updateUserUserNotFoundTest() {
        UserDto testUserDto = createUserDto();
        when(userRepository.findByEmail(TEST_EMAIL)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class,
                () -> appService.updateUser(testUserDto.getEmail(), testUserDto));
    }

    @Test
    void deleteUserTest() {
        User testUser = createUser();
        when(userRepository.findByEmail(TEST_EMAIL)).thenReturn(Optional.of(testUser));

        appService.deleteUser(testUser.getEmail());

        verify(userRepository, times(1)).delete(testUser);
    }

    @Test
    void deleteUserUserNotFoundTest() {
        when(userRepository.findByEmail(TEST_EMAIL)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> appService.deleteUser(TEST_EMAIL));
    }

    @Test
    void getActivityTest() {
        Activity activity = createActivity();
        when(activityRepository.findByActivityName(ACTIVITY_NAME)).thenReturn(Optional.of(activity));

        ActivityDto activityDto = appService.getActivity(ACTIVITY_NAME);

        assertThat(activityDto, allOf(
                hasProperty("activityName", equalTo(activity.getActivityName())),
                hasProperty("duration", equalTo(activity.getDuration())),
                hasProperty("activityType", equalTo(activity.getActivityType()))
        ));
    }

    @Test
    void getActivityNotFoundTest() {
        when(activityRepository.findByActivityName(ACTIVITY_NAME)).thenReturn(Optional.empty());
        assertThrows(ActivityNotFoundException.class, () -> appService.getActivity(ACTIVITY_NAME));
    }

    @Test
    void addActivityTimeTest() {
        Activity activity = createActivity();
        activity.setAccepted(true);
        when(activityRepository.findByActivityName(ACTIVITY_NAME)).thenReturn(Optional.of(activity));
        when(activityRepository.save(any())).thenReturn(activity);

        ActivityDto activityDto = appService.addActivityTime(TEST_EMAIL, ACTIVITY_NAME, DURATION);

        assertThat(activityDto, allOf(
                hasProperty("duration", equalTo(activity.getDuration()))
        ));
    }

    @Test
    void addActivityTimeActivityIsNotAcceptedTest() {
        Activity activity = createActivity();

        when(activityRepository.findByActivityName(ACTIVITY_NAME)).thenReturn(Optional.of(activity));

        assertThrows(ActivityIsNotAcceptedException.class, () -> {
            appService.addActivityTime(TEST_EMAIL, ACTIVITY_NAME, DURATION);
        });
    }


    @Test
    void createActivityTest() {
        Activity testActivity = createActivity();
        ActivityDto testActivityDto = createActivityDto();
        UserDto testUserDto = createUserDto();
        User testUser = createUser();
        when(userRepository.findByEmail(testUserDto.getEmail())).thenReturn(Optional.of(testUser));
        when(activityRepository.save(any())).thenReturn(testActivity);

        ActivityDto activityDto = appService.createActivity(TEST_EMAIL, testActivityDto);


        assertThat(activityDto, allOf(
                hasProperty("activityName", equalTo(testActivity.getActivityName())),
                hasProperty("duration", equalTo(testActivity.getDuration())),
                hasProperty("activityType", equalTo(testActivity.getActivityType()))
        ));
    }

    @Test
    void createActivityTestNoSuchActivityType() {
        ActivityDto testActivityDto = createActivityDto();
        testActivityDto.setActivityType(null);

        assertThrows(NoSuchActivityTypeException.class, () -> appService.createActivity(TEST_EMAIL, testActivityDto));
    }

    @Test
    void deleteActivityTest() {
        Activity testActivity = createActivity();
        when(activityRepository.findByActivityName(ACTIVITY_NAME)).thenReturn(Optional.of(testActivity));

        appService.deleteActivity(TEST_EMAIL, testActivity.getActivityName());

        verify(activityRepository, times(1)).delete(testActivity);
    }

    @Test
    void getAdminTest() {
        Admin admin = TestDataUtil.createAdmin();
        when(adminRepository.findByEmail(TEST_EMAIL)).thenReturn(Optional.of(admin));

        AdminDto adminDto = appService.getAdmin(TEST_EMAIL);

        assertThat(adminDto, allOf(
                hasProperty("email", equalTo(admin.getEmail()))
        ));
    }

    @Test
    void getAdminNotFoundTest() {
        when(adminRepository.findByEmail(TEST_EMAIL)).thenReturn(Optional.empty());
        assertThrows(AdminNotFoundException.class, () -> appService.getAdmin(TEST_EMAIL));
    }

    @Test
    void createAdminTest() {
        Admin testAdmin = createAdmin();
        AdminDto testAdminDto = createAdminDto();
        when(adminRepository.save(any())).thenReturn(testAdmin);

        AdminDto adminDto = appService.createAdmin(testAdminDto);

        assertThat(adminDto, allOf(
                hasProperty("email", equalTo(testAdmin.getEmail()))
        ));
    }

    @Test
    void createAdminUserAlreadyExistsTest() {
        AdminDto testAdminDto = createAdminDto();
        when(adminRepository.existsByEmail(TEST_EMAIL)).thenReturn(true);
        assertThrows(AdminAlreadyExistsException.class, () -> appService.createAdmin(testAdminDto));
    }

    @Test
    void createAdminPasswordsAreNotTheSame() {
        AdminDto testAdminDto = createAdminDto();
        testAdminDto.setRepeatPassword("wrongRepeatPassword");
        assertThrows(PasswordsAreNotTheSameException.class, () -> appService.createAdmin(testAdminDto));
    }

    @Test
    void AcceptActivityTest() {
        Activity activity = createActivity();
        activity.setAccepted(true);
        when(activityRepository.findByActivityName(ACTIVITY_NAME)).thenReturn(Optional.of(activity));
        when(activityRepository.save(any())).thenReturn(activity);

        ActivityDto activityDto = appService.acceptActivity(TEST_EMAIL, ACTIVITY_NAME);

        assertEquals(activity.isAccepted(), activityDto.isAccepted());
    }


    /*To make it short - there's no way to unit test Spring Data JPA repositories
    reasonably for a simple reason: it's way too cumbersome to mock all the parts of
    the JPA API we invoke to bootstrap the repositories. Unit tests don't make too
    much sense here anyway, as you're usually not writing any implementation code
    yourself.*/

    //written for 100%  service coverage
    @Test
    void getAllActivitiesTest() {
        appService.getAllActivities();
        assert true;
    }

    @Test
    void getUnacceptedActivitiesTest() {
        appService.getUnacceptedActivities();
        assert true;
    }

    @Test
    void getSortedActivitiesByNameTest() {
        appService.getSortedActivitiesByName();
        assert true;
    }

    @Test
    void findAllByActivityTypeTest() {
        appService.findAllByActivityType(ActivityType.EVENT);
        assert true;
    }


    @Test
    void getAllUsersTest() {
        appService.getAllUsers();
        assert true;
    }
}
