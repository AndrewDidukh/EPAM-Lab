package com.didukh.service.controller;

import com.didukh.service.api.AdminActivityApi;
import com.didukh.service.controller.assembler.AdminActivityAssembler;
import com.didukh.service.controller.model.AdminActivityModel;
import com.didukh.service.dto.AdminActivityDto;
import com.didukh.service.model.enums.ActivityType;
import com.didukh.service.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class AdminActivityController implements AdminActivityApi {
    private final AdminService adminService;
    private final AdminActivityAssembler adminActivityAssembler;
    private final PagedResourcesAssembler<AdminActivityDto> pagedResourcesAssembler;


    @Override
    public PagedModel<AdminActivityModel> getAllActivities(Pageable pageable) {
        Page<AdminActivityDto> adminActivities =adminService.getAllActivities(pageable);
        return pagedResourcesAssembler.toModel(adminActivities,adminActivityAssembler);
    }

    @Override
    public PagedModel<AdminActivityModel> getUnacceptedActivities(Pageable pageable) {
        Page<AdminActivityDto> adminActivities =adminService.getUnacceptedActivities(pageable);
        return pagedResourcesAssembler.toModel(adminActivities,adminActivityAssembler);
    }

    @Override
    public PagedModel<AdminActivityModel> getSortedActivitiesByName(Pageable pageable) {
        Page<AdminActivityDto> adminActivities =adminService.getSortedActivitiesByName(pageable);
        return pagedResourcesAssembler.toModel(adminActivities,adminActivityAssembler);
    }

    @Override
    public PagedModel<AdminActivityModel> findAllByActivityType(ActivityType activityType, Pageable pageable) {
        Page<AdminActivityDto> adminActivities =adminService.findAllByActivityType(activityType,pageable);
        return pagedResourcesAssembler.toModel(adminActivities,adminActivityAssembler);
    }

}
