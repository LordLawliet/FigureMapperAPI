package com.lguerrerodev03.figure_mapper_api.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lguerrerodev03.figure_mapper_api.persistence.entity.Image;
import com.lguerrerodev03.figure_mapper_api.persistence.entity.Point;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FigureDTO {

    private Long id;
    private String name;
    private String description;
    private Image image;
    private List<Point> pointList;
}
