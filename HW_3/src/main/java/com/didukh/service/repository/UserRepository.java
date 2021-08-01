package com.didukh.service.repository;

import com.didukh.service.model.Activity;
import com.didukh.service.model.User;

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
