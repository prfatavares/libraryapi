package br.com.atavares.libraryapi.repository;

import br.com.atavares.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
}
