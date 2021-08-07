package com.didukh.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class Admin{
    private String email;
    private String password;

}
