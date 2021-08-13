package com.didukh.service.mapper;

import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.AdminActivityDto;
import com.didukh.service.model.Activity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ActivityToAdminActivity {
    ActivityToAdminActivity INSTANCE= Mappers.getMapper(ActivityToAdminActivity.class);
    AdminActivityDto mapActivityToAdminActivityDto(Activity activity);
    Activity mapActivityDtoToActivity(AdminActivityDto adminActivityDto);
}
