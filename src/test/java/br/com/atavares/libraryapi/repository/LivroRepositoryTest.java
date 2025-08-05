package br.com.atavares.libraryapi.repository;

import br.com.atavares.libraryapi.model.Autor;
import br.com.atavares.libraryapi.model.GeneroLivro;
import br.com.atavares.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    List<Livro> livros = new ArrayList<>();

    @Test
    public void salvarTest(){
        Livro livro = new Livro();

        livro.setTitulo("Poesias");
        livro.setIsbn("0123456789");
        livro.setGenero(GeneroLivro.ROMANCE);
        livro.setPreco(BigDecimal.valueOf(89.90));

        Autor autor = autorRepository.findById(UUID.fromString("edd06fd8-08eb-44ee-a9bd-fee6edd69c15")).orElse(null);
        livro.setAutor(autor);

        livroRepository.save(livro);
        System.out.println("Livro salvo com sucesso: " + livro);
    }

    @Test
    public void salvarCascadeTest(){
        Livro livro = new Livro();

        livro.setTitulo("UFO");
        livro.setIsbn("987654321");
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setPreco(BigDecimal.valueOf(65.90));

        Autor autor = new Autor();

        autor.setNome("Coronel Paulo Silva");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1985, 9, 12));

        livro.setAutor(autor);
        livroRepository.save(livro);
    }

    @Test
    public void listarTest(){
        System.out.println("\nLivro por Título:\n" + livroRepository.findByTitulo("Poesias"));
        System.out.println("\nLivro por ISBN e ID:\n" + livroRepository.findByIsbnAndId("987654321", UUID.fromString("a9eb697b-a21e-4d63-9fe3-d331dfba2081")));
        livros = livroRepository.findByPrecoOrGenero(BigDecimal.valueOf(89.90), GeneroLivro.FICCAO);
        System.out.println("\nLivros por Preço ou Gênero:");
        livros.forEach(System.out::println);
    }

}