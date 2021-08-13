package com.didukh.service.api;

import com.didukh.service.controller.model.AdminModel;
import com.didukh.service.controller.model.UserModel;
import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.AdminDto;
import com.didukh.service.dto.group.OnCreate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "Admin API")
@RequestMapping("/api/v1/admin")
public interface AdminApi {

    @ApiOperation("Create Admin")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    AdminModel createAdmin(@RequestBody @Validated(OnCreate.class) AdminDto adminDto);


    @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "Admin email")
    @ApiOperation("Get Admin")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}")
    AdminModel getAdmin(@PathVariable String email);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email"),
            @ApiImplicitParam(name = "activityName", paramType = "path", required = true, value = "Activity name")
    })
    @ApiOperation("Accept Activity")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(value = "/accept/{email}/{activityName}")
    ActivityDto acceptActivity(@PathVariable String email, @PathVariable String activityName);

    @ApiOperation("Get All Users")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/getAllUsers")
    PagedModel<UserModel> getAllUsers(Pageable pageable);


}
