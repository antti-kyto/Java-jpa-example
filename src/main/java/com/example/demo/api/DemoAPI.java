package com.example.demo.api;

import com.example.demo.controller.PlayerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoAPI {

    @Autowired
    private PlayerController playerController;

    @GetMapping("/")
    public String index(){
        playerController.ListAllPlayers();
        return "Hello Spring Boot!";
    }
}
