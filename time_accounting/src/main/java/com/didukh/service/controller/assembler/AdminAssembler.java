package com.didukh.service.controller.assembler;

import com.didukh.service.controller.AdminController;
import com.didukh.service.controller.model.AdminModel;
import com.didukh.service.dto.AdminDto;
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
    public static final String GET_ALL_ACTIVITIES ="get_all_activities";
    public static final String GET_UNACCEPTED_ACTIVITIES ="get_unaccepted_activities";
    public static final String GET_SORTED_ACTIVITIES_BY_NAME="get_sorted_activities_by_name";
    public static final String GET_ACTIVITIES_BY_TYPE="get_activities_by_type";

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
        Link get_all_activities = linkTo(methodOn(AdminController.class).getAllActivities()).withRel(GET_ALL_ACTIVITIES);
        Link get_unaccepted_activities = linkTo(methodOn(AdminController.class).getUnacceptedActivities()).withRel(GET_UNACCEPTED_ACTIVITIES);
        Link get_sorted_activities_by_name = linkTo(methodOn(AdminController.class).getSortedActivitiesByName()).withRel(GET_SORTED_ACTIVITIES_BY_NAME);
        Link get_activities_by_type = linkTo(methodOn(AdminController.class).findAllByActivityType(null)).withRel(GET_ACTIVITIES_BY_TYPE);

        adminModel.add(get,create,get_all_users,get_all_activities,accept,get_unaccepted_activities,get_sorted_activities_by_name,get_activities_by_type);

        return adminModel;
    }
}