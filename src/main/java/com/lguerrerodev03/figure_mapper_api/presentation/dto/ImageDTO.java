package com.lguerrerodev03.figure_mapper_api.presentation.dto;

import com.lguerrerodev03.figure_mapper_api.persistence.entity.Figure;
import com.lguerrerodev03.figure_mapper_api.persistence.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ImageDTO {

    private Long id;
    private String name;
    private String imageURL;
    private String description;
    private Boolean isPublic;
    private User user;
    private List<Figure> figureList = new ArrayList<>();
}
