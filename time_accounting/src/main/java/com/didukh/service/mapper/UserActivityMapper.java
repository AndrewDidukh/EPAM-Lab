package com.didukh.service.mapper;

import com.didukh.service.dto.UserActivityDto;
import com.didukh.service.model.UserActivity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;



@Mapper
public interface UserActivityMapper {
    UserActivityMapper INSTANCE= Mappers.getMapper(UserActivityMapper.class);
    UserActivityDto mapUserActivityToUserActivityDto(UserActivity userActivity);
    UserActivity mapUserActivityDtoToUserActivity(UserActivityDto activityDto);
}
