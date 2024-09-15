package com.lguerrerodev03.figure_mapper_api.persistence.repository;

import com.lguerrerodev03.figure_mapper_api.persistence.entity.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {

    List<Image> findByIsPublicIsTrue();

    List<Image> findByIsPublicIsTrueAndAndNameContainingIgnoreCase(String name);

    List<Image> findByUserIdAndIsPublicIsTrue(Long userId);

    List<Image> findByUserId(Long userId);
}
