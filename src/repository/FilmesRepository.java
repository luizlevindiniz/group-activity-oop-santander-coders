package repository;

import model.Filme;

import java.util.List;
import java.util.Optional;

public interface FilmesRepository {
    public Filme inserir(Filme filme);

    public Filme atualizar(Filme filme);

    public void excluir(Filme filme);

    public List<Filme> pesquisarPorNome(String nome);

}
