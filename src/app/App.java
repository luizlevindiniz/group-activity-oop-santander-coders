package app;

import model.Filme;
import temp.FilmesRepository;

import java.util.List;

public class App {
    public static void main(String[] args) {

        FilmesRepository.insere("Uma lenda urbana");
        FilmesRepository.insere("Outro filme");

        List<Filme> lista = FilmesRepository.listarTodos();
        for (Filme filme : lista) {
            System.out.println(filme.toString());
        }

    }
}