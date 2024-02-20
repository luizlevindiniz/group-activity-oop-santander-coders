package repository.implementation;

import model.Filme;
import model.Diretor;
import model.Ator;
import repository.FilmesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilmesRepositoryImpl implements FilmesRepository {
    private final List<Filme> listaDeFilmes = new ArrayList<>();

    private final List<Ator> listaDeAtores = new ArrayList<>();

    private final List<Diretor> listaDeDiretores = new ArrayList<>();

    @Override
    public void inserir(Filme filme) {
        if (listaDeFilmes.stream().anyMatch((f) -> f.getTitulo().equals(filme.getTitulo()))) {
            System.out.println("Erro: O título '" + filme.getTitulo() + "' já existe na lista de filmes.");
        } else {
            listaDeFilmes.add(filme);
        }
    }

    @Override
    public Filme deletar(int id) {
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

    @Override
    public Filme alteraNome(int id, String nome) {
        Optional<Filme> filmeOptional = listaDeFilmes.stream().filter(f -> f.getId() == id).findFirst();
        if (filmeOptional.isPresent()) {
            Filme filme = filmeOptional.get();
            filme.setTitulo(nome);
            return filme;
        } else {
            throw new IllegalArgumentException("Filme com ID " + id + " não encontrado");
        }
    }

    @Override
    public List<Filme> listarTodos() {
        return listaDeFilmes;
    }

    @Override
    public List<Filme> pesquisarPorNome(String nome) {
        return listaDeFilmes.stream().filter(filme ->
                filme.getTitulo().contains(nome)).collect(Collectors.toList());
    }

    @Override
    public void inserirDiretor(Diretor diretores) {
        if (listaDeDiretores.stream().anyMatch((f) -> f.getNome().equals(diretores.getNome()))) {
            System.out.println("Erro: O nome '" + diretores.getNome() + "' já existe na lista de diretores.");
        } else {
            listaDeDiretores.add(diretores);
        }
    }

    @Override
    public Diretor deletarDiretor(int id){
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
    public List<Diretor> listarTodosDiretores(){
        return listaDeDiretores;
    }

    @Override
    public void inserirAtor(Ator atores) {
        if (listaDeAtores.stream().anyMatch((f) -> f.getNome().equals(atores.getNome()))) {
            System.out.println("Erro: O nome '" + atores.getNome() + "' já existe na lista de atores.");
        } else {
            listaDeAtores.add(atores);
        }
    }
    @Override
    public Ator deletarAtor(int id){
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
    public List<Ator> listarTodosAtores(){
        return listaDeAtores;
    }

    @Override
    public void exibirDetalhes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, insira o ID do filme para ver os detalhes:");
        int idFilme = scanner.nextInt();

        Optional<Filme> filmeOptional = listaDeFilmes.stream().filter(f -> f.getId() == idFilme).findFirst();

        if (filmeOptional.isPresent()) {
            Filme filme = filmeOptional.get();
            System.out.println("Detalhes do Filme:");
            System.out.println("Título: " + filme.getTitulo());
            System.out.println("Data de Lançamento: " + filme.getDataDeLancamento());
            System.out.println("Descrição: " + filme.getDescricao());
            System.out.println("Orçamento: " + filme.getOrcamento());

            System.out.println("Atores:");
            filme.getAtores().forEach(ator -> System.out.println("- " + ator.getNome()));

            System.out.println("Diretores:");
            filme.getDiretores().forEach(diretor -> System.out.println("- " + diretor.getNome()));
        } else {
            System.out.println("Filme com ID " + idFilme + " não encontrado");
        }
    }


}



