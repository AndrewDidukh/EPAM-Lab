package com.didukh.service.controller.model;

import com.didukh.service.dto.AdminActivityDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class AdminActivityModel extends RepresentationModel<AdminActivityModel> {
    @JsonUnwrapped
    private List<AdminActivityDto> adminActivityDto;
}
