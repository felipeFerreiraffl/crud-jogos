package br.com.jogos.controller;

import br.com.jogos.model.Jogo;
import br.com.jogos.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogo")
public class JogoController {

    // Referencia o service e seus métodos
    @Autowired
    private JogoService serv;

    @GetMapping
    public List<Jogo> getAllJogos() {
        return serv.getAllJogos();
    }

    @GetMapping("/{id}")
    public Jogo getJogoById(Long id) {
        return serv.getJogoById(id);
    }

    @PostMapping
    public Jogo createJogo(@RequestBody Jogo jogo) {
        return serv.createJogo(jogo);
    }

    @PutMapping("/{id}")
    public Jogo updateJogo(@PathVariable Long id,@RequestBody Jogo jogo) {
        return serv.updateJogo(id, jogo);
    }

    @DeleteMapping("/{id}")
    public void deleteJogo(Long id) {
        serv.deleteJogo(id);
    }

    @DeleteMapping
    public void deleteAllJogos() {
        serv.deleteAllJogos();
    }
}
