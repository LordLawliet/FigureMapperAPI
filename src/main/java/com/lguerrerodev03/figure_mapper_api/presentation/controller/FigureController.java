package com.lguerrerodev03.figure_mapper_api.presentation.controller;

import com.lguerrerodev03.figure_mapper_api.persistence.entity.Figure;
import com.lguerrerodev03.figure_mapper_api.persistence.entity.Image;
import com.lguerrerodev03.figure_mapper_api.persistence.entity.Point;
import com.lguerrerodev03.figure_mapper_api.presentation.dto.FigureDTO;
import com.lguerrerodev03.figure_mapper_api.presentation.dto.ImageDTO;
import com.lguerrerodev03.figure_mapper_api.service.implementation.FigureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/figures")
public class FigureController {

    @Autowired
    private FigureServiceImpl figureService;


    @GetMapping("/findAllByImageId/{imageId}")
    public ResponseEntity<?> findByImageId(@PathVariable Long imageId) {

        List<FigureDTO> figureDTOList = figureService.findByImageId(imageId)
                .stream()
                .map(figure -> FigureDTO.builder()
                        .id(figure.getId())
                        .name(figure.getName())
                        .description(figure.getDescription())
                        .image(figure.getImage())
                        .pointList(figure.getPointList())
                        .build())
                .toList();
        return ResponseEntity.ok(figureDTOList);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        Optional<Figure> figureOptional = figureService.findById(id);

        if (figureOptional.isPresent()) {
            Figure figure = figureOptional.get();
            FigureDTO figureDTO = FigureDTO.builder()
                    .id(figure.getId())
                    .name(figure.getName())
                    .description(figure.getDescription())
                    .image(figure.getImage())
                    .pointList(figure.getPointList())
                    .build();
            return ResponseEntity.ok(figureDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody FigureDTO figureDTO) throws URISyntaxException {

        if (figureDTO.getName().isBlank()
                || figureDTO.getDescription().isBlank()
                || figureDTO.getImage() == null
                || figureDTO.getPointList() == null || figureDTO.getPointList().size() < 3) {
            return ResponseEntity.badRequest().build();
        }

        // Crear la figura desde el DTO
        Figure figure = Figure.builder()
                .name(figureDTO.getName())
                .description(figureDTO.getDescription())
                .image(figureDTO.getImage())
                .build();

        // Asignar la figura a cada punto en la lista de puntos
        for (Point point : figureDTO.getPointList()) {
            point.setFigure(figure);  // Establecer la relación entre el punto y la figura
        }

        // Asignar la lista de puntos a la figura
        figure.setPointList(figureDTO.getPointList());

        // Guardar la figura con los puntos asociados
        figureService.save(figure);

        return ResponseEntity.created(new URI("/figures/save")).build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody FigureDTO figureDTO) {
        Optional<Figure> figureOptional = figureService.findById(id);

        if (figureOptional.isPresent()) {
            Figure figure = figureOptional.get();
            figure.setName(figureDTO.getName());
            figure.setDescription(figureDTO.getDescription());
            figure.setImage(figureDTO.getImage());
            figureService.save(figure);
            return ResponseEntity.ok("Registro Actualizado");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {

        if (id != null) {
            figureService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }

        return ResponseEntity.badRequest().build();
    }
}
