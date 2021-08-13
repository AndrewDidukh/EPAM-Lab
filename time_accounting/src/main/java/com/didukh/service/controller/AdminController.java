package com.didukh.service.controller;

import com.didukh.service.api.AdminApi;
import com.didukh.service.controller.assembler.AdminAssembler;
import com.didukh.service.controller.assembler.UserAssembler;
import com.didukh.service.controller.model.AdminModel;
import com.didukh.service.controller.model.UserModel;
import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.AdminDto;
import com.didukh.service.dto.UserDto;
import com.didukh.service.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminController implements AdminApi {

    private final AdminService adminService;
    private final AdminAssembler adminAssembler;
    private final UserAssembler userAssembler;
    private final PagedResourcesAssembler<UserDto> pagedResourcesAssembler;

    public AdminModel createAdmin(AdminDto adminDto) {
        AdminDto outAdminDto = adminService.createAdmin(adminDto);
        return adminAssembler.toModel(outAdminDto);
    }

    public AdminModel getAdmin(String email) {
        AdminDto outAdminDto = adminService.getAdmin(email);
        return adminAssembler.toModel(outAdminDto);
    }

    public ActivityDto acceptActivity(String email, String activityName) {
        return adminService.acceptActivity(email, activityName);
    }

    public PagedModel<UserModel> getAllUsers(Pageable pageable) {

        Page<UserDto> page = adminService.getAllUsers(pageable);

        return pagedResourcesAssembler.toModel(page,userAssembler);
    }


}
