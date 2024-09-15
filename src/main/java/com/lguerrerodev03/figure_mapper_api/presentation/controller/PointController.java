package com.lguerrerodev03.figure_mapper_api.presentation.controller;

import com.lguerrerodev03.figure_mapper_api.persistence.entity.Point;
import com.lguerrerodev03.figure_mapper_api.presentation.dto.PointDTO;
import com.lguerrerodev03.figure_mapper_api.service.implementation.PointServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/points")
public class PointController {

    @Autowired
    private PointServiceImpl pointService;



    @GetMapping("/findByImageId/{imageId}")
    public ResponseEntity<?> findByImageId(@PathVariable Long imageId) {

        List<PointDTO> pointDTOList = pointService.findByImageId(imageId)
                .stream()
                .map(point -> PointDTO.builder()
                        .id(point.getId())
                        .coordinateX(point.getCoordinateX())
                        .coordinateY(point.getCoordinateY())
                        //.figure(point.getFigure())
                        .build())
                .toList();

        return ResponseEntity.ok(pointDTOList);
    }

    @GetMapping("/findByFigureId/{figureId}")
    public ResponseEntity<?> findByFigureId(@PathVariable Long figureId) {

        List<PointDTO> pointDTOList = pointService.findByFigureId(figureId)
                .stream()
                .map(point -> PointDTO.builder()
                        .id(point.getId())
                        .coordinateX(point.getCoordinateX())
                        .coordinateY(point.getCoordinateY())
                        //.figure(point.getFigure())
                        .build())
                .toList();

        return ResponseEntity.ok(pointDTOList);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        List<PointDTO> pointDTOList = pointService.findById(id)
                .stream()
                .map(point -> PointDTO.builder()
                        .id(point.getId())
                        .coordinateX(point.getCoordinateX())
                        .coordinateY(point.getCoordinateY())
                        //.figure(point.getFigure())
                        .build())
                .toList();

        return ResponseEntity.ok(pointDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PointDTO pointDTO) throws URISyntaxException {

        if (pointDTO.getCoordinateX() == null || pointDTO.getCoordinateY() == null || pointDTO.getFigure() == null) {
            return ResponseEntity.badRequest().build();
        }

        pointService.save(Point.builder()
                .coordinateX(pointDTO.getCoordinateX())
                .coordinateY(pointDTO.getCoordinateY())
                .figure(pointDTO.getFigure())
                .build());
        return ResponseEntity.created(new URI("/points/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PointDTO pointDTO) {

        Optional<Point> pointOptional = pointService.findById(id);

        if (pointOptional.isPresent()) {
            Point point = pointOptional.get();
            point.setCoordinateX(pointDTO.getCoordinateX());
            point.setCoordinateY(pointDTO.getCoordinateY());
            point.setFigure(pointDTO.getFigure());
            pointService.update(point);
            return ResponseEntity.ok("Registro Actualizado");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        if (id != null) {
            pointService.delete(id);
            return ResponseEntity.ok("Registro eliminado");
        }

        return ResponseEntity.badRequest().build();
    }

}
