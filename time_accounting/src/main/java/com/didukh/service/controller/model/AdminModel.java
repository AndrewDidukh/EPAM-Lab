package com.didukh.service.controller.model;

import com.didukh.service.dto.AdminDto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class AdminModel extends RepresentationModel<UserModel> {

    @JsonUnwrapped
    private AdminDto adminDto;
}
