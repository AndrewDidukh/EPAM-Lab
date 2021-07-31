package com.didukh.service.dto;

import com.didukh.service.Model.Activity;
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
}
