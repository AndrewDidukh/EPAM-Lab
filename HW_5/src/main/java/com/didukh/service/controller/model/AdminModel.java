package com.didukh.service.controller.model;

import com.didukh.service.dto.AdminDto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class AdminModel extends RepresentationModel<UserModel> {

    @JsonUnwrapped
    private AdminDto userDto;
}
