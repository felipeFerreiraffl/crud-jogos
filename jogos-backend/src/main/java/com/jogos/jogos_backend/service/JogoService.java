package com.jogos.jogos_backend.service;

import com.jogos.jogos_backend.model.Jogo;
import com.jogos.jogos_backend.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    @Autowired
    private JogoRepository repository;

    // Busca todos os jogos
    public List<Jogo> getAllJogos() {
        return repository.findAll();
    }

    // Busca um jogo pelo ID
    public Jogo getJogoById(Long id) {
        Optional<Jogo> jogo = repository.findById(id);

        if (jogo.isPresent()) {
            return jogo.get();
        } else {
            throw new RuntimeException("Jogo não encontrado");
        }
    }

    // Cria um jogo
    public Jogo createJogo(Jogo jogo) {
        return repository.save(jogo);
    }
}
