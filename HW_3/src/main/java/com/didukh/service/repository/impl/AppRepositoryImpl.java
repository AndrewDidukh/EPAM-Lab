package com.didukh.service.repository.impl;

import com.didukh.service.model.*;
import com.didukh.service.repository.AppRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppRepositoryImpl implements AppRepository {

    private final List<User> userList = new ArrayList<>();
    private final List<Admin> adminlist = new ArrayList<>();

    @Override
    public User getUser(String email) {
        return userList.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElseThrow(() -> new RuntimeException("User is not found"));
    }

    @Override
    public User createUser(User user) {
        userList.add(user);
        return user;
    }

    @Override
    public User updateUser(String email, User user) {
        boolean isDeleted = userList.removeIf(u -> u.getEmail().equals(email));
        if (isDeleted) {
            userList.add(user);
        } else {
            throw new RuntimeException("User is not found");
        }
        return user;
    }

    @Override
    public void deleteUser(String email) {
        userList.removeIf(user -> user.getEmail().equals(email));
    }

    @Override
    public Activity getActivity(String email, String activityName) {
        return getUser(email).getActivities().stream().filter(act -> act.getActivityName().equals(activityName)).findFirst().orElseThrow(() -> new RuntimeException("Activity is not found"));
    }

    @Override
    public Activity addActivityTime(String email, String activityName, long seconds) {
        Activity activity = getActivity(email, activityName);
        if (activity.isAccepted()) {
            activity.getDuration().plusSeconds(seconds);
        } else
            throw new RuntimeException("Activity is not accepted");
        return activity;
    }

    @Override
    public Activity updateActivity(String email, String activityName, Activity activity) {
        boolean isDeleted = getUser(email).getActivities().removeIf(act -> act.getActivityName().equals(activityName));
        if (isDeleted) {
            createActivity(email, activity);
        } else {
            throw new RuntimeException("User with such activity is not found");
        }
        return activity;
    }

    @Override
    public Activity createActivity(String email, Activity activity) {

        getUser(email).getActivities().add(activity);
        return activity;
    }

    @Override
    public void deleteActivity(String email, String activityName) {
        getUser(email).getActivities().removeIf(act -> act.getActivityName().equals(activityName));
    }


    @Override
    public Admin createAdmin(Admin admin) {
        adminlist.add(admin);
        return admin;
    }

    @Override
    public Admin getAdmin(String email) {
        return adminlist.stream().filter(admin -> admin.getEmail().equals(email)).findFirst().orElseThrow(() -> new RuntimeException("Admin is not found"));
    }

    @Override
    public Activity acceptActivity(String email, String activityName) {
        getActivity(email, activityName).setAccepted(true);
        return getActivity(email, activityName);
    }

    @Override
    public Map<String, Activity> getUnacceptedActivities() {
        Map<String, Activity> activities = new HashMap<>();
        for (User user : userList) {
            List<Activity> activityList = user.getActivities();
            for (Activity activity : activityList) {
                if (!activity.isAccepted()) {
                    activities.put(user.getEmail(), activity);
                }
            }
        }
        return activities;
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }


}
