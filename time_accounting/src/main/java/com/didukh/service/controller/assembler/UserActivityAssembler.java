package com.didukh.service.controller.assembler;

import com.didukh.service.controller.UserActivityController;
import com.didukh.service.controller.model.UserActivityModel;
import com.didukh.service.dto.UserActivityDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserActivityAssembler extends RepresentationModelAssemblerSupport<UserActivityDto, UserActivityModel> {
    public static final String GET_ACT="get_activity";
    public static final String CREATE_ACT="create_activity";
    public static final String DELETE_ACT="delete_activity";
    public static final String ADD_TIME="add_time";

    public UserActivityAssembler() {
        super(UserActivityController.class, UserActivityModel.class);
    }

    @Override
    public UserActivityModel toModel(UserActivityDto entity) {
        UserActivityModel userActivityModel = new UserActivityModel(entity);
        Link getA = linkTo(methodOn(UserActivityController.class).getActivity(entity.getEmail(), entity.getActivityName())).withRel(GET_ACT);
        Link createA = linkTo(methodOn(UserActivityController.class).createActivity(entity.getEmail(),null)).withRel(CREATE_ACT);
        Link deleteA = linkTo(methodOn(UserActivityController.class).deleteActivity(entity.getEmail(),null)).withRel(DELETE_ACT);
        Link addTime = linkTo(methodOn(UserActivityController.class).addActivityTime(entity.getEmail(), null,0)).withRel(ADD_TIME);



        userActivityModel.add(getA,createA,deleteA,addTime);
        return userActivityModel;
    }
}
