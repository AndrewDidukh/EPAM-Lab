package com.didukh.service.controller;

import com.didukh.service.controller.assembler.AdminAssembler;
import com.didukh.service.controller.model.AdminModel;
import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.AdminDto;
import com.didukh.service.dto.UserDto;
import com.didukh.service.dto.group.OnCreate;
import com.didukh.service.dto.group.OnUpdate;
import com.didukh.service.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final AdminAssembler adminAssembler;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AdminModel createAdmin(@RequestBody @Validated(OnCreate.class) AdminDto adminDto) {
        AdminDto outAdminDto = adminService.createAdmin(adminDto);
        return adminAssembler.toModel(outAdminDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}")
    public AdminModel getAdmin(@PathVariable String email) {
        AdminDto outAdminDto = adminService.getAdmin(email);
        return adminAssembler.toModel(outAdminDto);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(value = "/accept/{email}/{activityName}")
    public ActivityDto acceptActivity(@PathVariable String email, @PathVariable String activityName) {
        return adminService.acceptActivity(email, activityName);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/getAllUsers")
    public List<UserDto> getAllUsers() {
        return adminService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/getUnacceptedActivities")
    public Map<String, ActivityDto> getUnacceptedActivities() {
        return adminService.getUnacceptedActivities();
    }

}
