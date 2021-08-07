package com.didukh.service.repository;

import com.didukh.service.model.Activity;
import com.didukh.service.model.Admin;
import com.didukh.service.model.User;

import java.util.List;
import java.util.Map;

public interface AppRepository {

    User getUser(String email);

    User createUser(User user);

    User updateUser(String email, User user);

    void deleteUser(String email);

    Activity getActivity(String email, String activityName);

    Activity addActivityTime(String email, String activityName, long seconds);

    Activity updateActivity(String email, String activityName, Activity activity);

    Activity createActivity(String email, Activity activity);

    void deleteActivity(String email, String activityName);


    Admin createAdmin(Admin admin);

    Admin getAdmin(String email);

    Activity acceptActivity(String email, String activityName);

    Map<String, Activity> getUnacceptedActivities();

    List<User> getAllUsers();
}
