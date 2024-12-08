package br.com.jogos.service;

import br.com.jogos.model.Jogo;
import br.com.jogos.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    // Conexão com o banco de dados do Repositório
    @Autowired
    private JogoRepository repo;

    // Busca todos os jogos
    public List<Jogo> getAllJogos() {
        return repo.findAll();
    }

    // Busca um jogo pelo seu ID
    public Jogo getJogoById(Long id) {
        Optional<Jogo> jogo = repo.findById(id);

        if (jogo.isPresent()) {
            return jogo.get();
        } else {
            throw new RuntimeException("Jogo não encontrado");
        }
    }

    // Cria um jogo
    public Jogo createJogo(Jogo jogo) {
        return repo.save(jogo);
    }

    // Atualiza um jogo
    public Jogo updateJogo(Long id, Jogo jogo) {
        Jogo existingJogo = getJogoById(id);

        existingJogo.setNome(jogo.getNome());
        existingJogo.setDtCriacao(jogo.getDtCriacao());
        existingJogo.setDesenvolvedor(jogo.getDesenvolvedor());
        existingJogo.setPlataforma(jogo.getPlataforma());
        existingJogo.setPreco(jogo.getPreco());

        return repo.save(existingJogo);
    }

    // Exclui um jogo
    public void deleteJogo(Long id) {
        Jogo jogo = getJogoById(id);
        repo.delete(jogo);
    }

    // Exclui todos os jogos do banco
    public void deleteAllJogos() {
        repo.deleteAll();
    }
}
