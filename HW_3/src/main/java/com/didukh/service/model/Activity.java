package com.didukh.service.model;

import lombok.Builder;
import lombok.Data;

import java.time.Duration;

@Data
@Builder
public class Activity {

    private String activityName;
    private Duration duration;

    public Activity(String activityName, Duration duration) {
        this.activityName = activityName;
        this.duration = duration;
    }
}
