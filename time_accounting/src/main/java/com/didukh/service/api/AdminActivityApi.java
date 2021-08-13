package com.didukh.service.api;

import com.didukh.service.controller.model.AdminActivityModel;
import com.didukh.service.dto.AdminActivityDto;
import com.didukh.service.model.enums.ActivityType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@Api(tags = "AdminActivity API")
@RequestMapping("/api/v1/admin")
public interface AdminActivityApi {
    @ApiOperation("Get All Activities")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/getAllActivities")
    PagedModel<AdminActivityModel> getAllActivities(Pageable pageable);

    @ApiOperation("Get unaccepted activities")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/getUnacceptedActivities")
    PagedModel<AdminActivityModel> getUnacceptedActivities(Pageable pageable);

    @ApiOperation("Get sorted activities by name")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/getSortedActivitiesByName")
    PagedModel<AdminActivityModel> getSortedActivitiesByName(Pageable pageable);

    @ApiImplicitParam(name = "activityType", paramType = "path", required = true, value = "Activity type")
    @ApiOperation("Get sorted activities by type")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{activityType}/findAllByActivityType")
    PagedModel<AdminActivityModel> findAllByActivityType(@PathVariable ActivityType activityType, Pageable pageable);
}
