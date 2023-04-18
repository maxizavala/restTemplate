package com.deg.restTemplate.controller;

import com.deg.restTemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getUsers() {
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(this.userService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createPost() {
        return new ResponseEntity<>(this.userService.createPost(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(){
        return new ResponseEntity<>(this.userService.updateUser(), HttpStatus.OK);
    }
}
