package com.didukh.service.controller.model;

import com.didukh.service.dto.AdminActivityDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.RepresentationModel;


@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class AdminActivityModel extends RepresentationModel<AdminActivityModel> {
    @JsonUnwrapped
    private AdminActivityDto adminActivityDto;
}
