package com.didukh.service.dto;

import com.didukh.service.dto.group.OnCreate;
import com.didukh.service.dto.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminDto{

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

    public AdminDto(String email, String password, String repeatPassword) {
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }
}
