package com.lguerrerodev03.figure_mapper_api.persistence.dao;

import com.lguerrerodev03.figure_mapper_api.persistence.entity.Figure;

import java.util.List;
import java.util.Optional;

public interface IFigureDAO {

    //List<Figure> findAll();

    List<Figure> findByImageId(Long imageId);

    Optional<Figure> findById(Long id);

    void save(Figure figure);

    void update(Figure figure);

    void deleteById(Long id);
}
