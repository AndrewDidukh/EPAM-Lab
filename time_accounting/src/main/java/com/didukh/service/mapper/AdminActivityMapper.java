package com.didukh.service.mapper;

import com.didukh.service.dto.AdminActivityDto;
import com.didukh.service.model.AdminActivity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AdminActivityMapper {
    AdminActivityMapper INSTANCE= Mappers.getMapper(AdminActivityMapper.class);

    AdminActivityDto mapAdminActivityToAdminActivityDto(AdminActivity adminActivity);
    AdminActivity mapAdminActivityDtoToAdminActivity(AdminActivityDto activityDto);
    List<AdminActivityDto> mapAdminActivityListToAdminActivityDtoList(List<AdminActivity> list);
}
