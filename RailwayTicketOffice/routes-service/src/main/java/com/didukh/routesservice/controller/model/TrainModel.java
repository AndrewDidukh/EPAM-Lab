package com.didukh.routesservice.controller.model;

import com.didukh.routesservice.model.Train;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class TrainModel extends RepresentationModel<TrainModel> {
    @JsonUnwrapped
    private Train train;
}
