package com.didukh.service.repository.impl;

import com.didukh.service.Model.Activity;
import com.didukh.service.Model.User;
import com.didukh.service.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserReposityImpl implements UserRepository {

    private final List<User> list = new ArrayList<>();

    @Override
    public User getUser(String email) {
        return list.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElseThrow(()->new RuntimeException("User is not found"));
    }

    @Override
    public User createUser(User user) {
        list.add(user);
        return user;
    }

    @Override
    public User updateUser(String email, User user) {
        boolean isDeleted = list.removeIf(u -> u.getEmail().equals(email));
        if (isDeleted){
            list.add(user);
        } else {
            throw new RuntimeException("User is not found");
        }
        return user;
    }

    @Override
    public void deleteUser(String email) {
        list.removeIf(user -> user.getEmail().equals(email));
    }

    @Override
    public Activity getActivity(String email, String activityName) {
        return getUser(email).getActivities().stream().filter(act->act.getActivityName().equals(activityName)).findFirst().orElseThrow(()->new RuntimeException("Activity is not found"));
    }

    @Override
    public Activity updateActivity(String email, String activityName, Activity activity) {
        boolean isDeleted = getUser(email).getActivities().removeIf(act -> act.getActivityName().equals(activityName));
        if (isDeleted){
            createActivity(email,activity);
        } else {
            throw new RuntimeException("User with such activity is not found");
        }
        return activity;
    }

    @Override
    public Activity createActivity(String email, Activity activity) {
        if (getUser(email).getActivities()==null) {
            getUser(email).setActivities(new ArrayList<>());
        }
        getUser(email).getActivities().add(activity);
        return activity;
    }

    @Override
    public void deleteActivity(String email,String activityName) {
        getUser(email).getActivities().removeIf(act->act.getActivityName().equals(activityName));
    }


}
