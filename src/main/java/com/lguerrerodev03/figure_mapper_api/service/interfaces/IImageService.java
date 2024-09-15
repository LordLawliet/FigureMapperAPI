package com.lguerrerodev03.figure_mapper_api.service.interfaces;

import com.lguerrerodev03.figure_mapper_api.persistence.entity.Image;

import java.util.List;
import java.util.Optional;

public interface IImageService {

    List<Image> findPublicImages();

    List<Image> findPublicImagesByName(String imageName);

    List<Image> findPublicImagesByUserId(Long userId);

    List<Image> findByUserId(Long userId);

    Optional<Image> findById(Long id);

    void saveImage(Image image);

    void updateImage(Image image);

    void deleteImage(Long id);
}
