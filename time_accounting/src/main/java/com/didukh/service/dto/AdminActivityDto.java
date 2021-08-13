package com.didukh.service.dto;


import com.didukh.service.dto.group.OnCreate;
import com.didukh.service.dto.group.OnUpdate;
import com.didukh.service.model.enums.ActivityType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminActivityDto {

    @NotBlank(message = "'activityName' shouldn`t be empty",groups = OnCreate.class)
    private String activityName;

    @Null(message = "'duration' should be absent in request",groups = {OnUpdate.class,OnCreate.class})
    private Integer duration;

    @NotNull(message = "'activityType' shouldn`t be empty",groups = OnCreate.class)
    @Null(message = "'activityType' should be absent in request",groups = {OnUpdate.class})
    @Enumerated(EnumType.STRING)
    private ActivityType activityType;

    private boolean isAccepted;
}
