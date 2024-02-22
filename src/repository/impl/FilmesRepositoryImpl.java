package repository.impl;

import model.Filme;
import model.Ator;
import model.Diretor;

import repository.AtoresRepository;
import repository.DiretoresRepository;
import repository.FilmesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilmesRepositoryImpl implements FilmesRepository {
    private final List<Filme> listaDeFilmes = new ArrayList<>();



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
    public Filme alterarNome(int id, String nome) {
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



