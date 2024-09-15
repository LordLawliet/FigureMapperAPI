package com.lguerrerodev03.figure_mapper_api.persistence.impl;

import com.lguerrerodev03.figure_mapper_api.persistence.dao.IFigureDAO;
import com.lguerrerodev03.figure_mapper_api.persistence.entity.Figure;
import com.lguerrerodev03.figure_mapper_api.persistence.repository.FigureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FigureDAOImpl implements IFigureDAO {

    @Autowired
    private FigureRepository figureRepository;

    @Override
    public List<Figure> findByImageId(Long imageId) {
        return figureRepository.findByImageId(imageId);
    }

    @Override
    public Optional<Figure> findById(Long id) {
        return figureRepository.findById(id);
    }

    @Override
    public void save(Figure figure) {
        figureRepository.save(figure);
    }

    @Override
    public void update(Figure figure) {
        figureRepository.save(figure);
    }

    @Override
    public void deleteById(Long id) {
        figureRepository.deleteById(id);
    }
}
