package com.jogos.jogos_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "jogo")
@Table(name = "jogo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dtLancamento;
    private String desenvolvedor;

    @Enumerated(EnumType.STRING)
    private Genero genero;
    private String[] plataformas;
    private double preco;
}
