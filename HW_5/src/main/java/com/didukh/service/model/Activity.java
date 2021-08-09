package com.didukh.service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Activity.getUnacceptedActivities",query = "SELECT a from Activity  a where a.isAccepted=false")
public class Activity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String activityName;
    private Integer duration;
    private boolean isAccepted;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public Activity addDuration(int minutes) {
        duration += minutes;
        return this;
    }


}
