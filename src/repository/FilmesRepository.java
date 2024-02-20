package repository;

import model.Filme;

import java.util.List;

public interface FilmesRepository {
    void inserir(Filme filme);

    Filme alteraNome(int id, String nome);

    Filme deletar(int id);

    List<Filme> pesquisarPorNome(String nome);

    List<Filme> listarTodos();

    void exibirDetalhes();

}
