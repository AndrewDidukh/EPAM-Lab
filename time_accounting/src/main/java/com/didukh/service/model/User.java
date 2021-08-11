package com.didukh.service.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Activity> activities;

    public List<Activity> getActivities() {
        return activities;
    }

    public User(String email, String password, String firstName, String lastName, List<Activity> activities) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.activities = activities;
    }


}
