package com.didukh.service.model;

import com.didukh.service.model.enums.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserActivity {

    private String email;
    private String activityName;
    private Integer duration;
    @Enumerated(EnumType.STRING)
    private ActivityType activityType;
    private boolean isAccepted;

    public UserActivity(String email, Activity activity) {
        this.email = email;
        this.activityName = activity.getActivityName();
        this.duration = activity.getDuration();
        this.activityType = activity.getActivityType();
        this.isAccepted = activity.isAccepted();
    }
}
