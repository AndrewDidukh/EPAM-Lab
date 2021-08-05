package com.didukh.service.dto;

import com.didukh.service.model.Activity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class UserDto{
    private String email;
    private String password;
    private String repeatPassword;
    private String firstName;
    private String lastName;
    private List<Activity> activities;

}
