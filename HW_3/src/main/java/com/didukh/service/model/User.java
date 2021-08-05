package com.didukh.service.model;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder

public class User{
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private List<Activity> activities;

    public List<Activity> getActivities() {
        return activities;
    }

    public User(String email, String password, String firstName, String lastName, List<Activity> activities) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.activities = new ArrayList<>();
    }
}
