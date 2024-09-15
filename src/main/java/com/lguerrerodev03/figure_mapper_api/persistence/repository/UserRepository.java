package com.lguerrerodev03.figure_mapper_api.persistence.repository;

import com.lguerrerodev03.figure_mapper_api.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUserName(String username);

    List<User> findByUserNameContainingIgnoreCase(String userName);
}
