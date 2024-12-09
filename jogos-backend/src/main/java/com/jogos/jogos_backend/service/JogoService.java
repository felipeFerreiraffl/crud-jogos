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

    // Atualizar um jogo
    public Jogo updateJogo(Long id, Jogo jogo) {
        Jogo existingJogo = getJogoById(id);

        existingJogo.setNome(jogo.getNome());
        existingJogo.setDtLancamento(jogo.getDtLancamento());
        existingJogo.setDesenvolvedor(jogo.getDesenvolvedor());
        existingJogo.setGenero(jogo.getGenero());
        existingJogo.setPlataformas(jogo.getPlataformas());
        existingJogo.setPreco(jogo.getPreco());

        return repository.save(existingJogo);
    }

    // Excluir um jogo
    public void deleteJogo(Long id) {
        Jogo jogo = getJogoById(id);
        repository.delete(jogo);
    }

    public void deleteAllJogos() {
        repository.deleteAll();
    }
}
