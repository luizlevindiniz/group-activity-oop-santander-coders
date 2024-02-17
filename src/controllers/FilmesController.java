package controllers;

import model.Filme;
import repository.FilmesRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FilmesController implements FilmesRepository {
    private static final List<Filme> listaDeFilmes = new ArrayList<>();
    private static FilmesController instance;

    private FilmesController(){

    }
    public static FilmesController getInstance(){
        if (instance == null){
            instance = new FilmesController();
        }
        return  instance;
    }

    @Override
    public void inserir(Filme filme) {
        if (listaDeFilmes.stream().anyMatch((f) -> f.getTitulo().equals(filme.getTitulo()))) {
            System.out.println("Erro: O título '" + filme.getTitulo() + "' já existe na lista de filmes.");
        } else {
            listaDeFilmes.add(filme);
        }
    }

    @Override
    public Filme deletar(int id){
        Optional<Filme> filmeOptional = listaDeFilmes.stream().filter(f -> f.getId() == id).findFirst();

        if (filmeOptional.isPresent()) {
            Filme filme = filmeOptional.get();
            listaDeFilmes.remove(filme);
            System.out.println("Filme deletado com sucesso: " + filme.getTitulo());
            return filme;
        } else {
            throw new IllegalArgumentException("Filme com ID " + id + " não encontrado");
        }
    }

    public Filme alteraNome(int id, String nome){
        Optional<Filme> filmeOptional  = listaDeFilmes.stream().filter(f -> f.getId() == id).findFirst();
        if (filmeOptional.isPresent()) {
            Filme filme = filmeOptional.get();
            filme.setTitulo(nome);
            return filme;
        } else {
            throw new IllegalArgumentException("Filme com ID " + id + " não encontrado");
        }
    }

    public List<Filme> listarTodos(){
        return listaDeFilmes;
    }

    public List<Filme> pesquisarPorNome(String nome){
        return listaDeFilmes.stream().filter(filme ->
                filme.getTitulo().contains(nome)).collect(Collectors.toList());
    }

}
