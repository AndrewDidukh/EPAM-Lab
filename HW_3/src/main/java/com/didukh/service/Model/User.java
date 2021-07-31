package com.didukh.service.Model;


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

}
