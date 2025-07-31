package br.com.atavares.libraryapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_autor", schema = "public")
@Data
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "nacionalidade", nullable = false, length = 50)
    private String nacionalidade;

    public Autor() {

    }

    public Autor(UUID id, String nome, LocalDate dataNascimento, String nacionalidade) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
    }
}
