package com.didukh.service.mapper;

import com.didukh.service.dto.UserDto;
import com.didukh.service.model.User;

import java.util.Objects;

public class UpdateMapping {
    public static void populateUserWithPresentUserDtoFields(User user, UserDto userDto){
        String firstName = userDto.getFirstName();
        if (Objects.nonNull(firstName)){
            user.setFirstName(firstName);
        }
        String lastName = userDto.getLastName();
        if (Objects.nonNull(lastName)){
            user.setLastName(lastName);
        }
    }
}
