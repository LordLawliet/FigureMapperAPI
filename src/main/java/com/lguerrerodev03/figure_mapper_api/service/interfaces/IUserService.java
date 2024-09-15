package com.lguerrerodev03.figure_mapper_api.service.interfaces;

import com.lguerrerodev03.figure_mapper_api.persistence.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> findByUserName(String userName);

    List<User> findAll();

    Optional<User> findById(Long id);

    Optional<User> findExistsUserName(String userName);

    void save(User user);

    void update(User user);

    void delete(Long id);
}
