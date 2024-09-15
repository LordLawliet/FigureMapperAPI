package com.lguerrerodev03.figure_mapper_api.presentation.dto;

import com.lguerrerodev03.figure_mapper_api.persistence.entity.Image;
import com.lguerrerodev03.figure_mapper_api.persistence.entity.Role;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {

    private Long id;
    private String userName;
    private String password;
    private Role role;
    private List<Image> imageList = new ArrayList<>();
}
