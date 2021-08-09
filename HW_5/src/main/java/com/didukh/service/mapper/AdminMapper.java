package com.didukh.service.mapper;

import com.didukh.service.dto.AdminDto;
import com.didukh.service.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapper {
    AdminMapper INSTANCE= Mappers.getMapper(AdminMapper.class);
    AdminDto mapAdminToAdminDto(Admin activity);
    Admin mapAdminDtoToAdmin(AdminDto activityDto);
}
