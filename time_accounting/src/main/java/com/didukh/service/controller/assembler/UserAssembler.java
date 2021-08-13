package com.didukh.service.controller.assembler;

import com.didukh.service.controller.UserController;
import com.didukh.service.controller.model.UserModel;
import com.didukh.service.dto.UserDto;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<UserDto, UserModel> {
    public static final String GET_USER="get_user";
    public static final String CREATE_USER="create_user";
    public static final String UPDATE_USER="update_user";
    public static final String DELETE_USER="delete_user";





    public UserAssembler() {
        super(UserController.class,UserModel.class);
    }


    @Override
    public UserModel toModel(UserDto entity) {
        UserModel userModel = new UserModel(entity);
        Link getU = linkTo(methodOn(UserController.class).getUser(entity.getEmail())).withRel(GET_USER);
        Link createU = linkTo(methodOn(UserController.class).createUser(entity)).withRel(CREATE_USER);
        Link updateU = linkTo(methodOn(UserController.class).updateUser(entity.getEmail(),entity)).withRel(UPDATE_USER);
        Link deleteU = linkTo(methodOn(UserController.class).deleteUser(entity.getEmail())).withRel(DELETE_USER);




        userModel.add(getU,createU,updateU,deleteU);

        return userModel;
    }
}
