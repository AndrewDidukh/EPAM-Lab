package com.didukh.service.api;

import com.didukh.service.controller.model.UserActivityModel;
import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.group.OnCreate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Api(tags = "UserActivity API")
@RequestMapping("/api/v1/users/{email}")
public interface UserActivityApi {

    @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email")
    @ApiOperation("Create Activity")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    UserActivityModel createActivity(@PathVariable String email, @RequestBody @Validated(OnCreate.class) ActivityDto activityDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "activity", paramType = "path", required = true, value = "Activity name"),
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email")
    })
    @ApiOperation("Get Activity")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{activity}")
    UserActivityModel getActivity(@PathVariable String email, @PathVariable String activity);


    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email"),
            @ApiImplicitParam(name = "activity", paramType = "path", required = true, value = "Activity name"),
            @ApiImplicitParam(name = "seconds", paramType = "path", required = true, value = "Seconds to add")
    })
    @ApiOperation("Add Activity time")
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = "/{activity}/addTime/{minutes}")
    UserActivityModel addActivityTime(@PathVariable String email, @PathVariable String activity, @PathVariable int minutes);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email"),
            @ApiImplicitParam(name = "activity", paramType = "path", required = true, value = "Activity name")
    })
    @ApiOperation("Delete Activity")
    @DeleteMapping(value = "/{activity}")
    ResponseEntity<Void> deleteActivity(@PathVariable String email, @PathVariable String activity);
}
