package com.didukh.service.dto;

import com.didukh.service.dto.group.OnCreate;
import com.didukh.service.dto.group.OnUpdate;
import com.didukh.service.model.Activity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto{

    @NotBlank(message = "'firstName' shouldn`t be empty",groups = OnCreate.class)
    private String firstName;

    @NotBlank(message = "'lastName' shouldn`t be empty",groups = OnCreate.class)
    private String lastName;

    @Email
    @Null(message = "'email' should be absent in request",groups = OnUpdate.class)
    @NotBlank(message = "'email' shouldn`t be empty",groups = OnCreate.class)
    private String email;

    @Null(message = "'password' should be absent in request",groups = OnUpdate.class)
    @NotBlank(message = "'password' shouldn`t be empty",groups = OnCreate.class)
    private String password;

    @Null(message = "'repeatPassword' should be absent in request",groups = OnUpdate.class)
    @NotBlank(message = "'repeatPassword' shouldn`t be empty",groups = OnCreate.class)
    private String repeatPassword;

    @Null(message = "'activities' should be absent in request",groups = OnCreate.class)
    private List<Activity> activities;

}
