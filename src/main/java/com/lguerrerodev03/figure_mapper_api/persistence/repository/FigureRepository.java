package com.lguerrerodev03.figure_mapper_api.persistence.repository;

import com.lguerrerodev03.figure_mapper_api.persistence.entity.Figure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FigureRepository extends CrudRepository<Figure, Long> {

    List<Figure> findByImageId(Long id);


}
