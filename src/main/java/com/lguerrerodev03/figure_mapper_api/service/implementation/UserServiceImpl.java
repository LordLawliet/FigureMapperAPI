package com.lguerrerodev03.figure_mapper_api.service.implementation;

import com.lguerrerodev03.figure_mapper_api.persistence.dao.IUserDAO;
import com.lguerrerodev03.figure_mapper_api.persistence.entity.User;
import com.lguerrerodev03.figure_mapper_api.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public List<User> findByUserName(String userName) {
        return userDAO.findByUserName(userName);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public Optional<User> findExistsUserName(String userName) {
        return userDAO.findExistsUserName(userName);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void delete(Long id) {
        userDAO.delete(id);
    }
}
