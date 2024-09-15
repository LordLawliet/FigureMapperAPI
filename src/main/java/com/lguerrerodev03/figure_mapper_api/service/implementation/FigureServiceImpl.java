package com.lguerrerodev03.figure_mapper_api.service.implementation;

import com.lguerrerodev03.figure_mapper_api.persistence.dao.IFigureDAO;
import com.lguerrerodev03.figure_mapper_api.persistence.entity.Figure;
import com.lguerrerodev03.figure_mapper_api.service.interfaces.IFigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FigureServiceImpl implements IFigureService {

    @Autowired
    private IFigureDAO figureDAO;

    @Override
    public List<Figure> findByImageId(Long imageId) {
        return figureDAO.findByImageId(imageId);
    }

    @Override
    public Optional<Figure> findById(Long id) {
        return figureDAO.findById(id);
    }

    @Override
    public void save(Figure figure) {
        figureDAO.save(figure);
    }

    @Override
    public void update(Figure figure) {
        figureDAO.update(figure);
    }

    @Override
    public void deleteById(Long id) {
        figureDAO.deleteById(id);
    }
}
