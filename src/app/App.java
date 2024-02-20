package app;

import model.*;
import controllers.FilmesController;
import model.builders.AtorBuilder;
import model.builders.DiretorBuilder;
import model.builders.FilmeBuilder;
import repository.implementation.FilmesRepositoryImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        FilmesRepositoryImpl repository = new FilmesRepositoryImpl();
        FilmesController filmesController = FilmesController.getInstance(repository);

        Ator ator1 = new AtorBuilder().comID(1).comNome("Brad Pitt").build();
        Ator ator2 = new AtorBuilder().comID(2).comNome("Sean Connery").build();

        Diretor diretor1 = new DiretorBuilder().comID(1).comNome("JJ Abrams").build();
        Diretor diretor2 = new DiretorBuilder().comID(2).comNome("Steven Spilberg").build();

        List<Ator> atores = new ArrayList<>();
        atores.add(ator1);
        atores.add(ator2);

        List<Diretor> diretores = new ArrayList<>();
        diretores.add(diretor1);
        diretores.add(diretor2);

        Filme filme1 = new FilmeBuilder().comID(1).comTitulo("Lagoa Azul").comDescricao("ABC")
                        .comOrcamento(BigDecimal.valueOf(123.4)).comLancamentoEm(LocalDate.parse("2023-01-01"))
                        .comAtores(atores).comDiretores(diretores).build();


        /*

        filmesController.inserir(filme1);

        List<Filme> lista = filmesController.listarTodos();
        lista.forEach((filme -> System.out.println(filme.toString())));
        filmesController.alteraNome(1, "Outro nome");
        lista.forEach((filme -> System.out.println(filme.toString())));
        filmesController.deletar(1);
        lista.forEach((filme -> System.out.println(filme.toString())));


        System.out.println(FilmesController.getInstance().pesquisarPorNome("Outro"));
         */

    }
}