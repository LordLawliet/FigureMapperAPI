package com.lguerrerodev03.figure_mapper_api.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "puntos")
public class Point {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "coordenada_x", nullable = false)
    private Integer coordinateX;

    @Column(name = "coordenada_y", nullable = false)
    private Integer coordinateY;

    @ManyToOne
    @JoinColumn(
            name = "id_figura",
            nullable = false
    )
    @JsonIgnore
    private Figure figure;
}
