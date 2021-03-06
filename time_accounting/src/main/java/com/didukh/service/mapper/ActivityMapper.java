package com.didukh.service.mapper;

import com.didukh.service.dto.ActivityDto;
import com.didukh.service.model.Activity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;



@Mapper
public interface ActivityMapper {
        ActivityMapper INSTANCE= Mappers.getMapper(ActivityMapper.class);
        ActivityDto mapActivityToActivityDto(Activity activity);
        Activity mapActivityDtoToActivity(ActivityDto activityDto);
        List<ActivityDto> mapActivityToActivityDtoInMap(List<Activity> map);
}
