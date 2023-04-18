package com.deg.restTemplate.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    RestTemplate restTemplate = new RestTemplate();
    public List<String> findAll(){
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", List.class);
    }

    public String findById(Long id){
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/"+id, String.class);
    }

    public String createPost(){
        Map<String, String> bodyMap = new HashMap<>();
        bodyMap.put("title", "HOLA MUNDO");
        bodyMap.put("body", "Mensaje de prueba");
        bodyMap.put("userId", "1");
        return restTemplate.postForObject("https://jsonplaceholder.typicode.com/posts", null, String.class, bodyMap);
    }

    public String updateUser(){
        Map<String, Object> mapUser = new HashMap<>();
        mapUser.put("name", "Juan");
        restTemplate.put("https://jsonplaceholder.typicode.com/users/1", mapUser);
        return "Usuario actualizado";
    }
}
