package com.didukh.service.dto;

import com.didukh.service.dto.group.OnCreate;
import com.didukh.service.dto.group.OnUpdate;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;


@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class ActivityDto  {

    @NotBlank(message = "'activityName' shouldn`t be empty",groups = OnCreate.class)
    private String activityName;

    @Null(message = "'duration' should be absent in request",groups = {OnUpdate.class,OnCreate.class})
    private Integer duration;

    private boolean isAccepted;

}
