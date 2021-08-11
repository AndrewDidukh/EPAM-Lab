package com.didukh.service.mapper;

import com.didukh.service.dto.UserDto;
import com.didukh.service.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface UserMapper {
        UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
        User mapUserDtoToUser(UserDto userDto);
        UserDto mapUserToUserDto(User user);
        List<UserDto> mapUsersToListDto(List<User> list);
}
