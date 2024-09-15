package com.lguerrerodev03.figure_mapper_api.presentation.controller;

import com.lguerrerodev03.figure_mapper_api.persistence.entity.Image;
import com.lguerrerodev03.figure_mapper_api.presentation.dto.ImageDTO;
import com.lguerrerodev03.figure_mapper_api.service.implementation.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageServiceImpl imageService;

    @GetMapping("/findAllPublics")
    public ResponseEntity<?> findPublicImages() {

        List<ImageDTO> imageDTOList = imageService.findPublicImages()
                .stream()
                .map(image -> ImageDTO.builder()
                        .id(image.getId())
                        .name(image.getName())
                        .imageURL(image.getImageURL())
                        .description(image.getDescription())
                        .isPublic(image.getIsPublic())
                        .user(image.getUser())
                        //.figureList(image.getFigureList())
                        .build())
                .toList();
        return ResponseEntity.ok(imageDTOList);
    }

    @GetMapping("/findAllPublicsByName/{imageName}")
    public ResponseEntity<?> findPublicImagesByName(@PathVariable String imageName) {

        List<ImageDTO> imageDTOList = imageService.findPublicImagesByName(imageName)
                .stream()
                .map(image -> ImageDTO.builder()
                        .id(image.getId())
                        .name(image.getName())
                        .imageURL(image.getImageURL())
                        .description(image.getDescription())
                        .isPublic(image.getIsPublic())
                        .user(image.getUser())
                        //.figureList(image.getFigureList())
                        .build())
                .toList();
        return ResponseEntity.ok(imageDTOList);
    }

    @GetMapping("/findAllPublicsByUserId/{userId}")
    public ResponseEntity<?> findPublicImagesByUserId(@PathVariable Long userId) {


        List<ImageDTO> imageDTOList = imageService.findPublicImagesByUserId(userId)
                .stream()
                .map(image -> ImageDTO.builder()
                        .id(image.getId())
                        .name(image.getName())
                        .imageURL(image.getImageURL())
                        .description(image.getDescription())
                        .isPublic(image.getIsPublic())
                        .user(image.getUser())
                        //.figureList(image.getFigureList())
                        .build())
                .toList();
        return ResponseEntity.ok(imageDTOList);
    }

    @GetMapping("/findAllByUserId/{userId}")
    public ResponseEntity<?> findByUserId(@PathVariable Long userId) {

        List<ImageDTO> imageDTOList = imageService.findByUserId(userId)
                .stream()
                .map(image -> ImageDTO.builder()
                        .id(image.getId())
                        .name(image.getName())
                        .imageURL(image.getImageURL())
                        .description(image.getDescription())
                        .isPublic(image.getIsPublic())
                        .user(image.getUser())
                        //.figureList(image.getFigureList())
                        .build())
                .toList();
        return ResponseEntity.ok(imageDTOList);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        Optional<Image> imageOptional = imageService.findById(id);

        if (imageOptional.isPresent()) {
            Image image = imageOptional.get();
            ImageDTO imageDTO = ImageDTO.builder()
                    .id(image.getId())
                    .name(image.getName())
                    .imageURL(image.getImageURL())
                    .description(image.getDescription())
                    .isPublic(image.getIsPublic())
                    .user(image.getUser())
                    .figureList(image.getFigureList())
                    .build();
            return ResponseEntity.ok(imageDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveImage(@RequestBody ImageDTO imageDTO) throws URISyntaxException {

        if (imageDTO.getName().isBlank()
                || imageDTO.getImageURL().isBlank()
                || imageDTO.getDescription().isBlank()
                || imageDTO.getUser() == null) {
            return ResponseEntity.badRequest().build();
        }

        imageService.saveImage(Image.builder()
                .name(imageDTO.getName())
                .imageURL(imageDTO.getImageURL())
                .description(imageDTO.getDescription())
                .isPublic(imageDTO.getIsPublic())
                .user(imageDTO.getUser())
                .build());
        return ResponseEntity.created(new URI("/images/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateImage(@PathVariable Long id, @RequestBody ImageDTO imageDTO) {
        Optional<Image> imageOptional = imageService.findById(id);
        if (imageOptional.isPresent()) {
            Image image = imageOptional.get();
            image.setName(imageDTO.getName());
            //image.setImageURL(imageDTO.getImageURL());
            image.setDescription(imageDTO.getDescription());
            image.setIsPublic(imageDTO.getIsPublic());
            //image.setUser(imageDTO.getUser());
            imageService.saveImage(image);
            return ResponseEntity.ok("Registro Actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteImage(@PathVariable Long id) {

        if (id != null) {
            imageService.deleteImage(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
