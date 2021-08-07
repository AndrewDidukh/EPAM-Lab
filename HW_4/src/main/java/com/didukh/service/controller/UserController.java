package com.didukh.service.controller;


import com.didukh.service.controller.assembler.UserAssembler;
import com.didukh.service.controller.model.UserModel;
import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.UserDto;
import com.didukh.service.dto.group.OnCreate;
import com.didukh.service.dto.group.OnUpdate;
import com.didukh.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserAssembler userAssembler;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserModel createUser(@RequestBody @Validated(OnCreate.class) UserDto userDto) {
        UserDto outUserDto=userService.createUser(userDto);
        return userAssembler.toModel(outUserDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}")
    public UserModel getUser(@PathVariable String email) {
        UserDto outUserDto=userService.getUser(email);
        return userAssembler.toModel(outUserDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{email}")
    public UserModel updateUser(@PathVariable String email, @RequestBody @Validated(OnUpdate.class) UserDto userDto) {
        UserDto outUserDto=userService.updateUser(email, userDto);
        return userAssembler.toModel(outUserDto);
    }

    @DeleteMapping(value = "/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/{email}")
    public ActivityDto createActivity(@PathVariable String email, @RequestBody @Validated(OnCreate.class) ActivityDto activityDto) {
        return userService.createActivity(email, activityDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}/{activity}")
    public ActivityDto getActivity(@PathVariable String email, @PathVariable String activity) {
        return userService.getActivity(email, activity);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{email}/updateActivity")
    public ActivityDto updateActivity(@PathVariable String email, @RequestBody @Validated(OnUpdate.class) ActivityDto activityDto) {
        return userService.updateActivity(email, activityDto.getActivityName(), activityDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = "/{email}/{activity}/addTime/{seconds}")
    public ActivityDto addActivityTime(@PathVariable String email, @PathVariable String activity, @PathVariable Long seconds) {
        return userService.addActivityTime(email, activity, seconds);
    }

    @DeleteMapping(value = "/{email}/{activity}")
    public ResponseEntity<Void> deleteActivity(@PathVariable String email, @PathVariable String activity) {
        userService.deleteActivity(email, activity);
        return ResponseEntity.noContent().build();
    }

}
