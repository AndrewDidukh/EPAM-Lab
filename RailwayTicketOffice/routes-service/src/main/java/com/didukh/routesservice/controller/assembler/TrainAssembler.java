package com.didukh.routesservice.controller.assembler;


import com.didukh.routesservice.controller.TrainController;
import com.didukh.routesservice.controller.model.TrainModel;
import com.didukh.routesservice.model.Train;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TrainAssembler extends RepresentationModelAssemblerSupport<Train, TrainModel> {
    public static final String GET_TRAIN="get_train";
    public static final String ADD_TRAIN="add_train";
    public static final String UPDATE_TRAIN="update_train";
    public static final String DELETE_TRAIN="delete_train";
    public static final String GET_ALL_TRAINS="get_all_trains";

    public TrainAssembler() {
        super(TrainController.class,TrainModel.class);
    }

    @Override
    public TrainModel toModel(Train entity) {
        TrainModel trainModel = new TrainModel(entity);
        Pageable page = PageRequest.of(0,10);

        Link get = linkTo(methodOn(TrainController.class).getTrain(entity.getId())).withRel(GET_TRAIN);
        Link add = linkTo(methodOn(TrainController.class).createTrain(entity)).withRel(ADD_TRAIN);
        Link update = linkTo(methodOn(TrainController.class).updateTrain(entity.getId(),entity)).withRel(UPDATE_TRAIN);
        Link delete = linkTo(methodOn(TrainController.class).deleteTrain(entity.getId())).withRel(DELETE_TRAIN);
        Link getAll= linkTo(methodOn(TrainController.class).getAllTrains(page)).withRel(GET_ALL_TRAINS);

        trainModel.add(get,add,update,delete,getAll);
        return trainModel;
    }
}
