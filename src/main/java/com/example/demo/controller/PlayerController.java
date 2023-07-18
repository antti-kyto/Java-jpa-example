package com.example.demo.controller;

import com.example.demo.data.model.Player;
import com.example.demo.data.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    public String ListAllPlayers()
    {
        List<Player> listPlayers = playerRepository.findAll();
        for (Player player : listPlayers){
            System.out.println(player.name);
        }
        return "listPlayers";
    }
}
