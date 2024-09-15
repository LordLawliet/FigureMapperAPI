package com.lguerrerodev03.figure_mapper_api.persistence.impl;

import com.lguerrerodev03.figure_mapper_api.persistence.dao.IPointDAO;
import com.lguerrerodev03.figure_mapper_api.persistence.entity.Point;
import com.lguerrerodev03.figure_mapper_api.persistence.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PointDAOImpl implements IPointDAO {

    @Autowired
    private PointRepository pointRepository;


    @Override
    public List<Point> findByImageId(Long id) {
        return pointRepository.findPointsByFigure_Image_Id(id);
    }

    @Override
    public List<Point> findByFigureId(Long id) {
        return pointRepository.findPointsByFigureId(id);
    }

    @Override
    public Optional<Point> findById(Long id) {
        return pointRepository.findById(id);
    }

    @Override
    public void save(Point point) {
        pointRepository.save(point);
    }

    @Override
    public void update(Point point) {
        pointRepository.save(point);
    }

    @Override
    public void delete(Long id) {
        pointRepository.deleteById(id);
    }
}
