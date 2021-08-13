package com.didukh.service.controller.assembler;

import com.didukh.service.controller.AdminActivityController;
import com.didukh.service.controller.model.AdminActivityModel;
import com.didukh.service.dto.AdminActivityDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AdminActivityAssembler extends RepresentationModelAssemblerSupport<List<AdminActivityDto>, AdminActivityModel> {
    public static final String GET_ALL_ACTIVITIES ="get_all_activities";
    public static final String GET_UNACCEPTED_ACTIVITIES ="get_unaccepted_activities";
    public static final String GET_SORTED_ACTIVITIES_BY_NAME="get_sorted_activities_by_name";
    public static final String GET_ACTIVITIES_BY_TYPE="get_activities_by_type";

    public AdminActivityAssembler() {
        super(AdminActivityController.class, AdminActivityModel.class);
    }


    @Override
    public AdminActivityModel toModel(List<AdminActivityDto> entity) {
        AdminActivityModel adminActivityModel = new AdminActivityModel(entity);

        Link get_all_activities = linkTo(methodOn(AdminActivityController.class).getAllActivities()).withRel(GET_ALL_ACTIVITIES);
        Link get_unaccepted_activities = linkTo(methodOn(AdminActivityController.class).getUnacceptedActivities()).withRel(GET_UNACCEPTED_ACTIVITIES);
        Link get_sorted_activities_by_name = linkTo(methodOn(AdminActivityController.class).getSortedActivitiesByName()).withRel(GET_SORTED_ACTIVITIES_BY_NAME);
        Link get_activities_by_type = linkTo(methodOn(AdminActivityController.class).findAllByActivityType(null)).withRel(GET_ACTIVITIES_BY_TYPE);

        return adminActivityModel.add(get_all_activities,get_unaccepted_activities,get_sorted_activities_by_name,get_activities_by_type);

    }
}
