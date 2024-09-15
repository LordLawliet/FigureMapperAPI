package com.lguerrerodev03.figure_mapper_api.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "imagenes")
public class Image {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String name;

    @Column(
            name = "url_imagen",
            length = 1000,
            nullable = false
    )
    private String imageURL;

    @Column(name = "descripcion", length = 1000)
    private String description;

    @Column(name = "es_publica", nullable = false)
    private Boolean isPublic;

    @ManyToOne
    @JoinColumn(
            name = "id_usuario",
            nullable = false
    )
    //@JsonIgnore
    private User user;

    @OneToMany(
            mappedBy = "image",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Figure> figureList = new ArrayList<>();
}
