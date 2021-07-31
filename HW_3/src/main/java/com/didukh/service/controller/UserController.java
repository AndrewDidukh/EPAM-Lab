package com.didukh.service.controller;


import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.UserDto;
import com.didukh.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}")
    public UserDto getUser(@PathVariable String email){
        return userService.getUser(email);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{email}")
    public UserDto updateUser(@PathVariable String email, @RequestBody UserDto userDto){
        return userService.updateUser(email, userDto);
    }

    @DeleteMapping(value = "/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email){
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}/{activity}")
    public ActivityDto getActivity(@PathVariable String email,@PathVariable String activity){
        return userService.getActivity(email,activity);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/{email}")
    public ActivityDto createActivity(@PathVariable String email,@RequestBody ActivityDto activityDto){
        return userService.createActivity(email, activityDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{email}/updateActivity")
    public ActivityDto updateActivity(@PathVariable String email, @RequestBody ActivityDto activityDto){
        return userService.updateActivity(email, activityDto.getActivityName(),activityDto);
    }

    @DeleteMapping(value = "/{email}/{activity}")
    public ResponseEntity<Void> deleteActivity(@PathVariable String email,@PathVariable String activity){
        userService.deleteActivity(email,activity);
        return ResponseEntity.noContent().build();
    }

}
