package com.lguerrerodev03.figure_mapper_api.service.interfaces;

import com.lguerrerodev03.figure_mapper_api.persistence.entity.Point;

import java.util.List;
import java.util.Optional;

public interface IPointService {


    //List<Point> findAll();

    List<Point> findByImageId(Long id);

    List<Point> findByFigureId(Long id);

    Optional<Point> findById(Long id);

    void save(Point point);

    void update(Point point);

    void delete(Long id);
}
