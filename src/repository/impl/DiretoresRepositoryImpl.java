package repository.impl;

import repository.DiretoresRepository;
import model.Diretor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DiretoresRepositoryImpl implements DiretoresRepository {
    private final List<Diretor> listaDeDiretores = new ArrayList<>();

    public void inserir(Diretor diretores) {
        if (listaDeDiretores.stream().anyMatch((f) -> f.getNome().equals(diretores.getNome()))) {
            System.out.println("Erro: O nome '" + diretores.getNome() + "' já existe na lista de diretores.");
        } else {
            listaDeDiretores.add(diretores);
        }
    }

    public Diretor deletar(int id) {
        Optional<Diretor> diretorOptional = listaDeDiretores.stream().filter(f -> f.getId() == id).findFirst();
        if (diretorOptional.isPresent()) {
            Diretor diretor = diretorOptional.get();
            listaDeDiretores.remove(diretor);
            System.out.println("Diretor deletado com sucesso: " + diretor.getNome());
            return diretor;
        } else {
            throw new IllegalArgumentException("Diretor com ID " + id + " não encontrado");
        }
    }


    public Diretor alterarNome(int id, String nome) {
        Optional<Diretor> diretorOptional = listaDeDiretores.stream().filter(f -> f.getId() == id).findFirst();
        if (diretorOptional.isPresent()) {
            Diretor diretor = diretorOptional.get();
            diretor.setNome(nome);
            return diretor;
        } else {
            throw new IllegalArgumentException("Diretor com ID " + id + " não encontrado");
        }
    }


    public List<Diretor> pesquisarPorNome(String nome) {
        return listaDeDiretores.stream().filter(diretor ->
                diretor.getNome().contains(nome)).collect(Collectors.toList());
    }

    public List<Diretor> listarTodos() {
        return listaDeDiretores;
    }
}
