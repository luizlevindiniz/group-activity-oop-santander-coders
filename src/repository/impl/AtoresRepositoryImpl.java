package repository.impl;

import model.Ator;
import repository.AtoresRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AtoresRepositoryImpl implements AtoresRepository {
    private final List<Ator> listaDeAtores = new ArrayList<>();

    public void inserir(Ator atores) {
        if (listaDeAtores.stream().anyMatch((f) -> f.getNome().equals(atores.getNome()))) {
            System.out.println("Erro: O nome '" + atores.getNome() + "' já existe na lista de atores.");
        } else {
            listaDeAtores.add(atores);
        }
    }

    public Ator deletar(int id){
        Optional<Ator> atorOptional = listaDeAtores.stream().filter(f -> f.getId() == id).findFirst();
        if (atorOptional.isPresent()) {
            Ator ator = atorOptional.get();
            listaDeAtores.remove(ator);
            System.out.println("Ator deletado com sucesso: " + ator.getNome());
            return ator;
        } else {
            throw new IllegalArgumentException("Ator com ID " + id + " não encontrado");
        }
    }


    public Ator alterarNome(int id, String nome) {
        Optional<Ator> atorOptional = listaDeAtores.stream().filter(f -> f.getId() == id).findFirst();
        if (atorOptional.isPresent()) {
            Ator ator = atorOptional.get();
            ator.setNome(nome);
            return ator;
        } else {
            throw new IllegalArgumentException("Ator com ID " + id + " não encontrado");
        }
    }


    public List<Ator> pesquisarPorNome(String nome) {
        return listaDeAtores.stream().filter(ator ->
                ator.getNome().contains(nome)).collect(Collectors.toList());
    }

    public List<Ator> listarTodos(){
        return listaDeAtores;
    }
}
