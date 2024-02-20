package controllers;

import repository.FilmesRepository;

public class FilmesController {

    private final FilmesRepository repository;
    private static FilmesController instance;

    private FilmesController(FilmesRepository repository) {
        this.repository = repository;
    }

    public static FilmesController getInstance(FilmesRepository repository) {
        if (instance == null) {
            instance = new FilmesController(repository);
        }
        return instance;
    }

    public void executar(String comando){
        if("listarTodos".equals(comando)){
            repository.listarTodos().forEach((filme -> System.out.println(filme.toString())));
        }
    }


}


