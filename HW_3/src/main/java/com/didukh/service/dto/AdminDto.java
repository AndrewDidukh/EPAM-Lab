package com.didukh.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminDto{
    private String email;
    private String password;
    private String repeatPassword;

    public AdminDto(String email, String password, String repeatPassword) {
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }
}
