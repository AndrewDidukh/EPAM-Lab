package com.didukh.service.mapper;

import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.UserDto;
import com.didukh.service.model.Activity;
import com.didukh.service.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;

@Mapper
public interface UserMapper {
        UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
        User mapUserDtoToUser(UserDto userDto);
        UserDto mapUserToUserDto(User user);
}
