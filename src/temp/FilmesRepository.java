/*
* Exercicio da aula - sera jogado fora
*
* */


package temp;

import model.Filme;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FilmesRepository {

    private static int contador = 1;
    private static final List<Filme> listaDeFilmes = new ArrayList<>();

    private FilmesRepository(){

    }
    public static Filme insere(String titulo){
        Filme filme = new Filme();
        filme.setId(contador);
        filme.setTitulo(titulo);
        contador++;
        listaDeFilmes.add(filme);
        return filme;
    }

    public static void deletar(int id){

    }

    public static Filme alteraNome(int id, String nome){
        Filme filme = listaDeFilmes.stream().filter(f -> f.getId() == id).findFirst().get();
        filme.setTitulo(nome);
        return filme;
    }

    public static List<Filme> listarTodos(){
        return listaDeFilmes;
    }

    public static List<Filme> pesquisarPorNome(String nome){
        return listaDeFilmes.stream().filter(filme ->
            filme.getTitulo().contains(nome)).collect(Collectors.toList());
    }
}
