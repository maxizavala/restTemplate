package com.deg.restTemplate.controller;

import com.deg.restTemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public ResponseEntity<?> getUsers() {
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }
}
