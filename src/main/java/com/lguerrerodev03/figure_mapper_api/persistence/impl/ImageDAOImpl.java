package com.lguerrerodev03.figure_mapper_api.persistence.impl;

import com.lguerrerodev03.figure_mapper_api.persistence.dao.IImageDAO;
import com.lguerrerodev03.figure_mapper_api.persistence.entity.Image;
import com.lguerrerodev03.figure_mapper_api.persistence.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ImageDAOImpl implements IImageDAO {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<Image> findPublicImages() {
        return imageRepository.findByIsPublicIsTrue();
    }

    @Override
    public List<Image> findPublicImagesByName(String imageName) {
        return imageRepository.findByIsPublicIsTrueAndAndNameContainingIgnoreCase(imageName);
    }

    @Override
    public List<Image> findPublicImagesByUserId(Long userId) {
        return imageRepository.findByUserIdAndIsPublicIsTrue(userId);
    }

    @Override
    public List<Image> findByUserId(Long userId) {
        return imageRepository.findByUserId(userId);
    }

    @Override
    public Optional<Image> findById(Long id) {
        return imageRepository.findById(id);
    }

    @Override
    public void saveImage(Image image) {
        imageRepository.save(image);
    }

    @Override
    public void updateImage(Image image) {
        imageRepository.save(image);
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }
}
