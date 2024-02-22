package controllers;

import model.Diretor;

import repository.DiretoresRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
public class DiretoresController {
    private final DiretoresRepository diretoresRepository;
    private static DiretoresController instance;

    private DiretoresController(DiretoresRepository diretoresRepository) {
        this.diretoresRepository = diretoresRepository;
    }

    public static DiretoresController getInstanceDiretores(DiretoresRepository diretoresRepository) {
        if (instance == null) {
            instance = new DiretoresController(diretoresRepository);
        }
        return instance;
    }
    public void executar(String comando){
        if("listarTodos".equals(comando)){
            diretoresRepository.listarTodos().forEach((diretor -> System.out.println(diretor.toString())));
        }
    }
    public void executar(String comando, Diretor diretor) {
        if ("inserir".equals(comando)) {
            diretoresRepository.inserir(diretor);
        }
    }

    public void executar(String comando, int id, String novoNome) {
        if ("alterarNome".equals(comando)) {
            diretoresRepository.alterarNome(id, novoNome);
        }
    }
    public void executar(String comando, int id) {
        if ("deletar".equals(comando)) {
            diretoresRepository.deletar(id);
        }
    }
    public List<Diretor> executar(String comando, String nomeParaPesquisar){
        if("pesquisarPorNome".equals(comando)){
            try{
                Optional<List<Diretor>> diretores = Optional.ofNullable(diretoresRepository.pesquisarPorNome(nomeParaPesquisar));
                if(diretores.isPresent()){
                    return diretores.orElse(Collections.emptyList());
                }
            }  catch (Exception e) {
                throw new RuntimeException("Erro ao pesquisar por nome", e);
            }
        }else {
            throw new IllegalArgumentException("Erro ao pesquisar por nome");
        }
        // Default return statement
        return Collections.emptyList();
    }
}
