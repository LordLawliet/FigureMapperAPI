package com.lguerrerodev03.figure_mapper_api.persistence.impl;

import com.lguerrerodev03.figure_mapper_api.persistence.dao.IUserDAO;
import com.lguerrerodev03.figure_mapper_api.persistence.entity.User;
import com.lguerrerodev03.figure_mapper_api.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDAOImpl implements IUserDAO {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public List<User> findByUserName(String userName) {
        return userRepository.findByUserNameContainingIgnoreCase(userName);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findExistsUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
