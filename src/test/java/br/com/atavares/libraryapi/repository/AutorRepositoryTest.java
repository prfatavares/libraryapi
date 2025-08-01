package br.com.atavares.libraryapi.repository;

import br.com.atavares.libraryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    private AutorRepository autorRepository;

    @Test
    public void salvarTest(){
        Autor autor = new Autor();

        autor.setNome("Carlos Drummond de Andrade");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1972, 12, 23));

        autorRepository.save(autor);
        System.out.println("Autor salvo com sucesso: " + autor);
    }
}
