package repository;

import model.Filme;



public interface FilmesRepository extends CRUDRepository<Filme> {
    void exibirDetalhes();
}
