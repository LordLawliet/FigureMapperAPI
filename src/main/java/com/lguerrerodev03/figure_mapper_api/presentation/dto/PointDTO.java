package com.lguerrerodev03.figure_mapper_api.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lguerrerodev03.figure_mapper_api.persistence.entity.Figure;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PointDTO {

    private Long id;
    private Integer coordinateX;
    private Integer coordinateY;
    private Figure figure;
}
