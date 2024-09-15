package com.lguerrerodev03.figure_mapper_api.presentation.controller;

import com.lguerrerodev03.figure_mapper_api.persistence.entity.Role;
import com.lguerrerodev03.figure_mapper_api.persistence.entity.User;
import com.lguerrerodev03.figure_mapper_api.presentation.dto.UserDTO;
import com.lguerrerodev03.figure_mapper_api.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserDTO userDTO = UserDTO.builder()
                    .id(user.getId())
                    .userName(user.getUsername())
                    .password(user.getPassword())
                    .role(user.getRole())
                    //.imageList(user.getImageList())
                    .build();
            return ResponseEntity.ok(userDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<UserDTO> userDTOList = userService.findAll()
                .stream()
                .map(user -> UserDTO.builder()
                        .id(user.getId())
                        .userName(user.getUsername())
                        .password(user.getPassword())
                        .role(user.getRole())
                        //.imageList(user.getImageList())
                        .build())
                .toList();
        return ResponseEntity.ok(userDTOList);
    }

    @GetMapping("/findByUserName/{userName}")
    public ResponseEntity<?> findByUserName(@PathVariable String userName){
        List<UserDTO> userDTOList = userService.findByUserName(userName)
                .stream()
                .map(user -> UserDTO.builder()
                        .id(user.getId())
                        .userName(user.getUsername())
                        .password(user.getPassword())
                        .role(user.getRole())
                        //.imageList(user.getImageList())
                        .build())
                .toList();
        return ResponseEntity.ok(userDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody UserDTO userDTO) throws URISyntaxException {

        if (userDTO.getUserName().isBlank() || userDTO.getPassword().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        if (userService.findExistsUserName(userDTO.getUserName()).isPresent()) {
            return ResponseEntity.badRequest().body("El nombre de usuario ya existe.");
        }

        userService.save(User.builder()
                        .userName(userDTO.getUserName())
                        .password(userDTO.getPassword())
                        .role(Role.USER)
                        .build());

        return ResponseEntity.created(new URI("/users/save")).build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserDTO userDTO) {

        Optional<User> userOptional = userService.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUserName(userDTO.getUserName());
            user.setPassword(userDTO.getPassword());
            userService.update(user);
            return ResponseEntity.ok("Registro Actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {

        if (id != null) {
            userService.delete(id);
            return ResponseEntity.ok("Registro eliminado");
        }

        return ResponseEntity.badRequest().build();
    }
}
