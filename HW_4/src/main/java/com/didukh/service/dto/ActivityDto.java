package com.didukh.service.dto;

import com.didukh.service.dto.group.OnCreate;
import com.didukh.service.dto.group.OnUpdate;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.time.Duration;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActivityDto  {

    @NotBlank(message = "'activityName' shouldn`t be empty",groups = OnCreate.class)
    private String activityName;

    @Null(message = "'duration' should be absent in request",groups = {OnUpdate.class,OnCreate.class})
    private Duration duration;

    @Null(message = "'isAccepted' should be absent in request",groups = {OnUpdate.class,OnCreate.class})
    private boolean isAccepted;

    public ActivityDto(String activityName, Duration duration, boolean isAccepted) {
        this.activityName = activityName;
        this.duration = duration;
        this.isAccepted = isAccepted;
    }
}
