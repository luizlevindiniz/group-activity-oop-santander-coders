package app;


import controllers.AtoresController;
import model.*;
import controllers.DiretoresController;
import controllers.FilmesController;
import model.builders.AtorBuilder;
import model.builders.DiretorBuilder;
import model.builders.FilmeBuilder;
import repository.impl.AtoresRepositoryImpl;
import repository.impl.DiretoresRepositoryImpl;
import repository.impl.FilmesRepositoryImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Repositories
        FilmesRepositoryImpl repository = new FilmesRepositoryImpl();
        DiretoresRepositoryImpl diretoresRepository = new DiretoresRepositoryImpl();
        AtoresRepositoryImpl atoresRepository = new AtoresRepositoryImpl();

        // Controllers
        FilmesController filmesController = FilmesController.getInstance(repository);
        DiretoresController diretoresController = DiretoresController.getInstanceDiretores(diretoresRepository);
        AtoresController atoresController = AtoresController.getInstanceAtores(atoresRepository);

        // Testando o controller de filmes

        System.out.println("---TESTANTO CONTROLLER DE FILMES---");

        Ator ator1 = new AtorBuilder().comID(1).comNome("Brad Pitt").build();
        Ator ator2 = new AtorBuilder().comID(2).comNome("Sean Connery").build();
        Ator ator3 = new AtorBuilder().comID(3).comNome("Keanu Norris").build();

        Diretor diretor1 = new DiretorBuilder().comID(1).comNome("JJ Abrams").build();
        Diretor diretor2 = new DiretorBuilder().comID(2).comNome("Steven Spilberg").build();
        Diretor diretor3 = new DiretorBuilder().comID(3).comNome("Walcir Carrasco").build();

        List<Ator> atores = new ArrayList<>();
        atores.add(ator1);
        atores.add(ator2);

        List<Diretor> diretores = new ArrayList<>();
        diretores.add(diretor1);
        diretores.add(diretor2);

        List<Ator> atores2 = new ArrayList<>();
        atores2.add(ator3);

        List<Diretor> diretores2 = new ArrayList<>();
        diretores2.add(diretor3);


        Filme filme1 = new FilmeBuilder().comID(1).comTitulo("Lagoa Azul").comDescricao("ABC")
                        .comOrcamento(BigDecimal.valueOf(123.4)).comLancamentoEm(LocalDate.parse("2023-01-01"))
                        .comAtores(atores).comDiretores(diretores).build();

        Filme filme2 = new FilmeBuilder().comID(2).comTitulo("Lagoa Mega Azul").comDescricao("Azul")
                        .comOrcamento(BigDecimal.valueOf(1223.4)).comLancamentoEm(LocalDate.parse("2023-01-01"))
                        .comAtores(atores2).comDiretores(diretores2).build();

        filmesController.executar("listarTodos");

        filmesController.executar("inserir",filme1);
        filmesController.executar("inserir",filme2);

        filmesController.executar("listarTodos");

        filmesController.executar("alterarNome",1, "Outro nome");
        filmesController.executar("listarTodos");

        filmesController.executar("deletar",1);
        filmesController.executar("listarTodos");

        System.out.println(filmesController.executar("pesquisarPorNome","Outro"));
        System.out.println(filmesController.executar("pesquisarPorNome","Azul"));

        filmesController.executar("exibirDetalhes"); // entrar o id do filme da lista de filmes

        System.out.println("\n");
        // Testando o controller de diretores

        System.out.println("---TESTANTO CONTROLLER DE DIRETORES---");

        diretoresController.executar("listarTodos");

        diretoresController.executar("inserir",diretor1);
        diretoresController.executar("inserir",diretor2);

        diretoresController.executar("listarTodos");

        diretoresController.executar("alterarNome",1,"David Villeneuve");
        diretoresController.executar("listarTodos");

        diretoresController.executar("deletar",1);
        diretoresController.executar("listarTodos");

        System.out.println(diretoresController.executar("pesquisarPorNome","Steven"));
        System.out.println(diretoresController.executar("pesquisarPorNome","Azul"));

        System.out.println("\n");
        // Testando o controller de diretores

        System.out.println("---TESTANTO CONTROLLER DE ATORES---");

        atoresController.executar("listarTodos");

        atoresController.executar("inserir",ator1);
        atoresController.executar("inserir",ator2);

        atoresController.executar("listarTodos");

        atoresController.executar("alterarNome",1,"Scarlett Johansson");
        atoresController.executar("listarTodos");

        atoresController.executar("deletar",1);
        atoresController.executar("listarTodos");

        System.out.println(atoresController.executar("pesquisarPorNome","Sean"));
        System.out.println(atoresController.executar("pesquisarPorNome","Azul"));
    }
}
