package com.didukh.service.controller.assembler;

import com.didukh.service.controller.AdminController;
import com.didukh.service.controller.UserController;
import com.didukh.service.controller.model.AdminModel;
import com.didukh.service.controller.model.UserModel;
import com.didukh.service.dto.AdminDto;
import com.didukh.service.dto.UserDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class AdminAssembler extends RepresentationModelAssemblerSupport<AdminDto, AdminModel> {
    public static final String GET_ADMIN="get_admin";
    public static final String CREATE_ADMIN="create_admin";
    public static final String ACCEPT_ACTIVITY="accept_activity";
    public static final String GET_ALL_USERS="get_all_users";
    public static final String GET_UNACCEPTED_ACTIVITIES="get_unaccepted_activities";



    public AdminAssembler() {
        super(AdminController.class,AdminModel.class);
    }


    @Override
    public AdminModel toModel(AdminDto entity) {
        AdminModel adminModel = new AdminModel(entity);

        Link get = linkTo(methodOn(AdminController.class).getAdmin(entity.getEmail())).withRel(GET_ADMIN);
        Link create = linkTo(methodOn(AdminController.class).createAdmin(entity)).withRel(CREATE_ADMIN);
        Link accept = linkTo(methodOn(AdminController.class).acceptActivity(null,null)).withRel(ACCEPT_ACTIVITY);
        Link get_all_users = linkTo(methodOn(AdminController.class).getAllUsers()).withRel(GET_ALL_USERS);
        Link get_unaccepted_activities = linkTo(methodOn(AdminController.class).getUnacceptedActivities()).withRel(GET_UNACCEPTED_ACTIVITIES);

        adminModel.add(get,create,get_all_users,get_unaccepted_activities,accept);

        return adminModel;
    }
}