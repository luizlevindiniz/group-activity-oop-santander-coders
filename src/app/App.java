package app;

import model.*;
import controllers.FilmesController;

import java.util.List;

public class App {
    public static void main(String[] args) {
        FilmesController filmesController = FilmesController.getInstance();

        Ator ator1 = new AtorBuilder().comID(1).comNome("Brad Pitt").build();
        Ator ator2 = new AtorBuilder().comID(2).comNome("Sean Connery").build();

        Diretor diretor1 = new DiretorBuilder().comID(1).comNome("JJ Abrams").build();
        Diretor diretor2 = new DiretorBuilder().comID(2).comNome("Steven Spilberg").build();

        Filme filme1 = new FilmeBuilder().comID(1).comTitulo("Lagoa Azul").build();

        /*
        List<Filme> lista = FilmesController.listarTodos();
        lista.forEach((filme -> System.out.println(filme.toString())));
        FilmesController.alteraNome(1, "Outro nome");
        lista.forEach((filme -> System.out.println(filme.toString())));
        FilmesController.deletar(1);
        lista.forEach((filme -> System.out.println(filme.toString())));


        System.out.println(FilmesController.pesquisarPorNome("Outro"));
        * */
    }
}