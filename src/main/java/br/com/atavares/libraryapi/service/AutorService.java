package br.com.atavares.libraryapi.service;

import br.com.atavares.libraryapi.model.Autor;
import br.com.atavares.libraryapi.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor salvar(Autor autor){
        return autorRepository.save(autor);
    }
}
