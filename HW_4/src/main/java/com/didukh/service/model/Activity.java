package com.didukh.service.model;

import lombok.Builder;
import lombok.Data;

import java.time.Duration;

@Data
@Builder
public class Activity {

    private String activityName;
    private Duration duration;
    private boolean isAccepted;

    public Activity(String activityName, Duration duration, boolean isAccepted) {
        this.activityName = activityName;
        this.duration = duration;
        this.isAccepted = isAccepted;
    }
}
