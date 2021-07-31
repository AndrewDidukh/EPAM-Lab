package com.didukh.service.Model;

import lombok.Builder;
import lombok.Data;

import java.time.Duration;

@Data
@Builder
public class Activity {

    private String activityName;
    private Duration duration;

}
