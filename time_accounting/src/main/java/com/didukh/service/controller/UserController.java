package com.didukh.service.controller;


import com.didukh.service.api.UserApi;
import com.didukh.service.controller.assembler.UserAssembler;
import com.didukh.service.controller.model.UserModel;
import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.UserDto;
import com.didukh.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;
    private final UserAssembler userAssembler;


    public UserModel createUser(UserDto userDto) {
        UserDto outUserDto = userService.createUser(userDto);
        return userAssembler.toModel(outUserDto);
    }


    public UserModel getUser(String email) {
        UserDto outUserDto = userService.getUser(email);
        return userAssembler.toModel(outUserDto);
    }


    public UserModel updateUser(String email, UserDto userDto) {
        UserDto outUserDto = userService.updateUser(email, userDto);
        return userAssembler.toModel(outUserDto);
    }


    public ResponseEntity<Void> deleteUser(String email) {
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }

    public ActivityDto createActivity(String email, ActivityDto activityDto) {
        return userService.createActivity(email, activityDto);
    }


    public ActivityDto getActivity(String activity) {
        return userService.getActivity( activity);
    }


    public ActivityDto addActivityTime(String email, String activity, int minutes) {
        return userService.addActivityTime(email, activity, minutes);
    }


    public ResponseEntity<Void> deleteActivity(String email, String activity) {
        userService.deleteActivity(email, activity);
        return ResponseEntity.noContent().build();
    }

}
