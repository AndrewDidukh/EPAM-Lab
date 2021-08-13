package com.didukh.service.controller;

import com.didukh.service.api.UserActivityApi;
import com.didukh.service.controller.assembler.UserActivityAssembler;
import com.didukh.service.controller.model.UserActivityModel;
import com.didukh.service.dto.ActivityDto;
import com.didukh.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserActivityController implements UserActivityApi {
    private final UserService userService;
    private final UserActivityAssembler userActivityAssembler;


    public UserActivityModel createActivity(String email, ActivityDto activityDto) {
        return userActivityAssembler.toModel(userService.createActivity(email, activityDto));
    }


    public UserActivityModel getActivity(String email, String activity) {
        return userActivityAssembler.toModel(userService.getActivity(email, activity));
    }


    public UserActivityModel addActivityTime(String email, String activity, int minutes) {
        return userActivityAssembler.toModel(userService.addActivityTime(email, activity, minutes));
    }


    public ResponseEntity<Void> deleteActivity(String email, String activity) {
        userService.deleteActivity(email, activity);
        return ResponseEntity.noContent().build();
    }
}
