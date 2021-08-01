package com.didukh.service.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Duration;

@Data
@Builder
public class ActivityDto  {
    private String activityName;
    private Duration duration;

    public ActivityDto(String activityName, Duration duration) {
        this.activityName = activityName;
        this.duration = duration;
    }
}
