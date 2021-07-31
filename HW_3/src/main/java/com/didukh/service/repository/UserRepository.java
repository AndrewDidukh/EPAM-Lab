package com.didukh.service.repository;

import com.didukh.service.Model.Activity;
import com.didukh.service.Model.User;

import java.util.List;

public interface UserRepository {

    User getUser(String email);

    User createUser(User user);

    User updateUser(String email, User user);

    void deleteUser(String email);

    Activity getActivity(String email, String activityName);

    Activity updateActivity(String email, String activityName, Activity activity);

    Activity createActivity(String email, Activity activity);

    void deleteActivity(String email,String activityName);
}
