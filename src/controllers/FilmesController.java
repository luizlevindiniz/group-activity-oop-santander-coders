package controllers;

import model.Diretor;
import model.Filme;
import repository.FilmesRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
        } else if ("exibirDetalhes".equals(comando)) {
            repository.exibirDetalhes();
        }
    }

    public void executar(String comando, Filme filme){
        if("inserir".equals(comando)){
            repository.inserir(filme);
        }
    }

    public void executar(String comando, int id, String novoNome){
        if("alterarNome".equals(comando)){
            repository.alterarNome(id,novoNome);
        }
    }
    public void executar(String comando, int id) {
        if ("deletar".equals(comando)) {
            repository.deletar(id);
        }

    }
    public List<Filme> executar(String comando, String nomeParaPesquisar){
        if("pesquisarPorNome".equals(comando)){
            try{
                Optional<List<Filme>> filmes = Optional.ofNullable(repository.pesquisarPorNome(nomeParaPesquisar));
                if(filmes.isPresent()){
                    return filmes.orElse(Collections.emptyList());
                }
            }  catch (Exception e) {
                throw new RuntimeException("Erro ao pesquisar por nome", e);
            }
        }else {
            throw new IllegalArgumentException("Erro ao pesquisar por nome");
        }
        // Default return statement
        return Collections.emptyList();
    }

}


