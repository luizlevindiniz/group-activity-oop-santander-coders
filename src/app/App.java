package app;

import model.Filme;
import controllers.FilmesController;

import java.util.List;

public class App {
    public static void main(String[] args) {
        FilmesController filmesController = FilmesController.getInstance();

        
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