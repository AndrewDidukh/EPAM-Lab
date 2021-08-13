package com.didukh.service.api;

import com.didukh.service.controller.model.AdminActivityModel;
import com.didukh.service.model.enums.ActivityType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
    AdminActivityModel getAllActivities();

    @ApiOperation("Get unaccepted activities")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/getUnacceptedActivities")
    AdminActivityModel getUnacceptedActivities();

    @ApiOperation("Get sorted activities by name")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/getSortedActivitiesByName")
    AdminActivityModel getSortedActivitiesByName();

    @ApiImplicitParam(name = "activityType", paramType = "path", required = true, value = "Activity type")
    @ApiOperation("Get sorted activities by type")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{activityType}/findAllByActivityType")
    AdminActivityModel findAllByActivityType(@PathVariable ActivityType activityType);
}
