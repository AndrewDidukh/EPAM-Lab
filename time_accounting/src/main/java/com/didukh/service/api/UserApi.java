package com.didukh.service.api;

import com.didukh.service.controller.model.UserModel;
import com.didukh.service.dto.UserDto;
import com.didukh.service.dto.group.OnCreate;
import com.didukh.service.dto.group.OnUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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



}
