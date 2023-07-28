package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.controller.PlayerController;
import com.example.demo.data.model.Player;
import com.example.demo.data.repository.PlayerRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Resource
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerController playerController;

    @Test
    void givenPlayer_whenSave_thenGetOk() {
        Player student = new Player(1, "john");
        playerRepository.save(student);

        String listPlayers = playerController.listAllPlayers();

        assertEquals("john", listPlayers);
    }

    @Test
    void givenPlayer_whenSave_thenGetFail() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("john")));
    }

}