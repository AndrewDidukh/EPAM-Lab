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
public class AdminActivity {
    private String activityName;
    private Integer duration;
    @Enumerated(EnumType.STRING)
    private ActivityType activityType;
    private boolean isAccepted;

    public AdminActivity(Activity activity) {
        this.activityName = activity.getActivityName();
        this.duration = activity.getDuration();
        this.activityType = activity.getActivityType();
        this.isAccepted = activity.isAccepted();
    }
}
