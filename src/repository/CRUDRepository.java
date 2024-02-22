package repository;

import java.util.List;

public interface CRUDRepository<T> {
    void inserir(T objeto);
    T deletar(int id);
    T alterarNome(int id, String nome);
    List<T> listarTodos();
    List<T> pesquisarPorNome(String nome);


}

