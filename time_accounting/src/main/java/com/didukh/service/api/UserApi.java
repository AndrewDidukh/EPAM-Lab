package com.didukh.service.api;

import com.didukh.service.controller.model.UserModel;
import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.UserDto;
import com.didukh.service.dto.group.OnCreate;
import com.didukh.service.dto.group.OnUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "User API")
@RequestMapping("/api/v1/users")
public interface UserApi {

    @ApiOperation("Create User")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserModel createUser(@RequestBody @Validated(OnCreate.class) UserDto userDto);


    @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email")
    @ApiOperation("Get User")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}")
    UserModel getUser(@PathVariable String email);


    @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email")
    @ApiOperation("Update User")
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = "/{email}")
    UserModel updateUser(@PathVariable String email, @RequestBody @Validated(OnUpdate.class) UserDto userDto);


    @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email")
    @ApiOperation("Delete User")
    @DeleteMapping(value = "/{email}")
    ResponseEntity<Void> deleteUser(@PathVariable String email);


    @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email")
    @ApiOperation("Create Activity")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/{email}")
    ActivityDto createActivity(@PathVariable String email, @RequestBody @Validated(OnCreate.class) ActivityDto activityDto);

    @ApiImplicitParam(name = "activity", paramType = "path", required = true, value = "Activity name")
    @ApiOperation("Get Activity")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "getActivity/{activity}")
    ActivityDto getActivity(@PathVariable String activity);


    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email"),
            @ApiImplicitParam(name = "activity", paramType = "path", required = true, value = "Activity name"),
            @ApiImplicitParam(name = "seconds", paramType = "path", required = true, value = "Seconds to add")
    })
    @ApiOperation("Add Activity time")
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = "/{email}/{activity}/addTime/{minutes}")
    ActivityDto addActivityTime(@PathVariable String email, @PathVariable String activity, @PathVariable int minutes);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email"),
            @ApiImplicitParam(name = "activity", paramType = "path", required = true, value = "Activity name")
    })
    @ApiOperation("Delete Activity")
    @DeleteMapping(value = "/{email}/{activity}")
    ResponseEntity<Void> deleteActivity(@PathVariable String email, @PathVariable String activity);
}
