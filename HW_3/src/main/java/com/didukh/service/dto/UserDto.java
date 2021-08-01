package com.didukh.service.dto;

import com.didukh.service.model.Activity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String repeatPassword;
    private List<Activity> activities;

    public UserDto(String firstName, String lastName, String email, String password, String repeatPassword, List<Activity> activities) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.activities = activities;
    }

    public UserDto(){

    }
}
