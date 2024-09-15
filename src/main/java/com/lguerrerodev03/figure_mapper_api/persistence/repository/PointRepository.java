package com.lguerrerodev03.figure_mapper_api.persistence.repository;

import com.lguerrerodev03.figure_mapper_api.persistence.entity.Point;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository extends CrudRepository<Point, Long> {

    List<Point> findPointsByFigure_Image_Id(Long imageId);

    List<Point> findPointsByFigureId(Long figureId);
}
