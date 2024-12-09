package com.jogos.jogos_backend.controller;

import com.jogos.jogos_backend.model.Jogo;
import com.jogos.jogos_backend.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogo")
public class JogoController {

    @Autowired
    private JogoService service;

    @GetMapping
    public List<Jogo> getAllJogos() {
        return service.getAllJogos();
    }

    @GetMapping("/{id}")
    public Jogo getJogoById(@PathVariable Long id) {
        return service.getJogoById(id);
    }

    @PostMapping
    public Jogo createJogo(@RequestBody Jogo jogo) {
        return service.createJogo(jogo);
    }

    @PutMapping("/{id}")
    public Jogo updateJogo(@PathVariable Long id, @RequestBody Jogo jogo) {
        return service.updateJogo(id, jogo);
    }

    @DeleteMapping("/{id}")
    public void deleteJogo(Long id) {
        service.deleteJogo(id);
    }

    @DeleteMapping
    public void deleteAllJogos() {
        service.deleteAllJogos();
    }
}
