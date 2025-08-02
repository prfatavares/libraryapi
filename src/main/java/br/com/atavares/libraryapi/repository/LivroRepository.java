package br.com.atavares.libraryapi.repository;

import br.com.atavares.libraryapi.model.GeneroLivro;
import br.com.atavares.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {

    Livro findByTitulo(String titulo);
    Livro findByIsbnAndId(String isbn, UUID id);
    List<Livro> findByPrecoOrGenero(BigDecimal preco, GeneroLivro genero);
}
