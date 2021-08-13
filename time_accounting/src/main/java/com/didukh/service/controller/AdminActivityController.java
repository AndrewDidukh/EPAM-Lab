package com.didukh.service.controller;

import com.didukh.service.api.AdminActivityApi;
import com.didukh.service.controller.assembler.AdminActivityAssembler;
import com.didukh.service.controller.model.AdminActivityModel;
import com.didukh.service.model.enums.ActivityType;
import com.didukh.service.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class AdminActivityController implements AdminActivityApi {
    private final AdminService adminService;
    private final AdminActivityAssembler adminActivityAssembler;

    public AdminActivityModel getAllActivities() {
        return adminActivityAssembler.toModel(adminService.getAllActivities());
    }

    public AdminActivityModel getUnacceptedActivities() {
        return adminActivityAssembler.toModel(adminService.getUnacceptedActivities());
    }

    public AdminActivityModel getSortedActivitiesByName() {
        return adminActivityAssembler.toModel(adminService.getSortedActivitiesByName());
    }

    public AdminActivityModel findAllByActivityType(ActivityType activityType) {
        return adminActivityAssembler.toModel(adminService.findAllByActivityType(activityType));
    }
}
