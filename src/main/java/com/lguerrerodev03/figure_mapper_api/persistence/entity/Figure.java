package com.lguerrerodev03.figure_mapper_api.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "figuras")
public class Figure {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String name;

    @Column(name = "descripcion", length = 1000)
    private String description;

    @ManyToOne
    @JoinColumn(
            name = "id_imagen",
            nullable = false
    )
    @JsonIgnore
    private Image image;

    @OneToMany(
            mappedBy = "figure",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Point> pointList;
}
