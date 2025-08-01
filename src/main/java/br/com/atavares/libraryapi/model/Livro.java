package br.com.atavares.libraryapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_livro", schema = "public")
@Data
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "isbn", nullable = false, length = 20, unique = true)
    private String isbn;

    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;

    @Column(name = "preco", precision = 18, scale = 2)
    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero", nullable = false, length = 30)
    private GeneroLivro genero;

    //ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false)
    private Autor autor;

    public Livro() {

    }

    public Livro(UUID id, String isbn, String titulo, BigDecimal preco, GeneroLivro genero, Autor autor) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.preco = preco;
        this.genero = genero;
        this.autor = autor;
    }
}
