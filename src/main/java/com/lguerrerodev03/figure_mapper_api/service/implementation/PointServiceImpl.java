package com.lguerrerodev03.figure_mapper_api.service.implementation;

import com.lguerrerodev03.figure_mapper_api.persistence.dao.IPointDAO;
import com.lguerrerodev03.figure_mapper_api.persistence.entity.Point;
import com.lguerrerodev03.figure_mapper_api.service.interfaces.IPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PointServiceImpl implements IPointService {

    @Autowired
    private IPointDAO pointDAO;

    @Override
    public List<Point> findByImageId(Long id) {
        return pointDAO.findByImageId(id);
    }

    @Override
    public List<Point> findByFigureId(Long id) {
        return pointDAO.findByFigureId(id);
    }

    @Override
    public Optional<Point> findById(Long id) {
        return pointDAO.findById(id);
    }

    @Override
    public void save(Point point) {
        pointDAO.save(point);
    }

    @Override
    public void update(Point point) {
        pointDAO.update(point);
    }

    @Override
    public void delete(Long id) {
        pointDAO.delete(id);
    }
}
