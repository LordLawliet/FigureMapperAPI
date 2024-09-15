package com.lguerrerodev03.figure_mapper_api.service.implementation;

import com.lguerrerodev03.figure_mapper_api.persistence.dao.IImageDAO;
import com.lguerrerodev03.figure_mapper_api.persistence.entity.Image;
import com.lguerrerodev03.figure_mapper_api.service.interfaces.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements IImageService {

    @Autowired
    private IImageDAO imageDAO;

    @Override
    public List<Image> findPublicImages() {
        return imageDAO.findPublicImages();
    }

    @Override
    public List<Image> findPublicImagesByName(String imageName) {
        return imageDAO.findPublicImagesByName(imageName);
    }

    @Override
    public List<Image> findPublicImagesByUserId(Long userId) {
        return imageDAO.findPublicImagesByUserId(userId);
    }

    @Override
    public List<Image> findByUserId(Long userId) {
        return imageDAO.findByUserId(userId);
    }

    @Override
    public Optional<Image> findById(Long id) {
        return imageDAO.findById(id);
    }

    @Override
    public void saveImage(Image image) {
        imageDAO.saveImage(image);
    }

    @Override
    public void updateImage(Image image) {
        imageDAO.updateImage(image);
    }

    @Override
    public void deleteImage(Long id) {
        imageDAO.deleteImage(id);
    }
}
