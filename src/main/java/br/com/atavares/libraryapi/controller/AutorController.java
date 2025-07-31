package br.com.atavares.libraryapi.controller;

import br.com.atavares.libraryapi.model.Autor;
import br.com.atavares.libraryapi.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(value = "autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public Autor salvar(@RequestBody Autor autor){
        autorService.salvar(autor);
        return autor;
    }

}
