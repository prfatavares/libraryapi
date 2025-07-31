package br.com.atavares.libraryapi.repository;

import br.com.atavares.libraryapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {
}
