/*
* Exercicio da aula - sera jogado fora
*
* */


package temp;

import model.Filme;

import java.util.ArrayList;
import java.util.List;

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

    public static void editar(int id){

    }

    public static List<Filme> listarTodos(){
        return listaDeFilmes;
    }
}
