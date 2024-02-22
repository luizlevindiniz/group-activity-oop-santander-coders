package controllers;

import model.Ator;
import repository.AtoresRepository;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
public class AtoresController {
    private final AtoresRepository atoresRepository;
    private static AtoresController instance;

    private AtoresController(AtoresRepository atoresRepository) {
        this.atoresRepository = atoresRepository;
    }

    public static AtoresController getInstanceAtores(AtoresRepository atoresRepository) {
        if (instance == null) {
            instance = new AtoresController(atoresRepository);
        }
        return instance;
    }
    public void executar(String comando){
        if("listarTodos".equals(comando)){
            atoresRepository.listarTodos().forEach((ator -> System.out.println(ator.toString())));
        }
    }
    public void executar(String comando, Ator ator) {
        if ("inserir".equals(comando)) {
            atoresRepository.inserir(ator);
        }
    }

    public void executar(String comando, int id, String novoNome) {
        if ("alterarNome".equals(comando)) {
            atoresRepository.alterarNome(id, novoNome);
        }
    }
    public void executar(String comando, int id) {
        if ("deletar".equals(comando)) {
            atoresRepository.deletar(id);
        }
    }
    public List<Ator> executar(String comando, String nomeParaPesquisar){
        if("pesquisarPorNome".equals(comando)){
            try{
                Optional<List<Ator>> atores = Optional.ofNullable(atoresRepository.pesquisarPorNome(nomeParaPesquisar));
                if(atores.isPresent()){
                    return atores.orElse(Collections.emptyList());
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
