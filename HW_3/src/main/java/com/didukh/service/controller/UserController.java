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


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}")
    public UserDto getUser(@PathVariable String email) {
        return userService.getUser(email);
    }


    @DeleteMapping(value = "/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/{email}")
    public ActivityDto createActivity(@PathVariable String email, @RequestBody ActivityDto activityDto) {
        return userService.createActivity(email, activityDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}/{activity}")
    public ActivityDto getActivity(@PathVariable String email, @PathVariable String activity) {
        return userService.getActivity(email, activity);
    }


    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = "/{email}/{activity}/addTime/{seconds}")
    public ActivityDto addActivityTime(@PathVariable String email, @PathVariable String activity, @PathVariable long seconds) {
        return userService.addActivityTime(email, activity, seconds);
    }

    @DeleteMapping(value = "/{email}/{activity}")
    public ResponseEntity<Void> deleteActivity(@PathVariable String email, @PathVariable String activity) {
        userService.deleteActivity(email, activity);
        return ResponseEntity.noContent().build();
    }

}
