package com.didukh.service.controller;

import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.AdminDto;
import com.didukh.service.dto.UserDto;
import com.didukh.service.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AdminDto createAdmin(@RequestBody AdminDto adminDto){
        return adminService.createAdmin(adminDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}")
    public AdminDto getAdmin(@PathVariable String email){
        return adminService.getAdmin(email);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(value = "/accept/{email}/{activityName}")
    public ActivityDto acceptActivity(@PathVariable String email,@PathVariable String activityName){
        return adminService.acceptActivity(email,activityName);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{email}")
    public UserDto updateUser(@PathVariable String email, @RequestBody UserDto userDto) {
        return adminService.updateUser(email, userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/updateActivity/{email}")
    public ActivityDto updateActivity(@PathVariable String email, @RequestBody ActivityDto activityDto) {
        return adminService.updateActivity(email, activityDto.getActivityName(), activityDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/getAllUsers")
    public List<UserDto> getAllUsers(){
        return adminService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/getUnacceptedActivities")
    public Map<String,ActivityDto> getUnacceptedActivities(){
        return adminService.getUnacceptedActivities();
    }

}
