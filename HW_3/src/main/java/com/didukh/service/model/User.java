package com.didukh.service.model;


import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Activity> activities;

    public User(String firstName, String lastName, String email, String password, List<Activity> activities) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.activities = activities;
    }

    public User(){

    }
}
