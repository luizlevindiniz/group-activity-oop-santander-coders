package model.builders;

import model.Ator;
import model.Diretor;
import model.Filme;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class FilmeBuilder {

    private final Filme filme = new Filme();

    public FilmeBuilder comTitulo(String titulo){
        filme.setTitulo(titulo);
        return this;
    }
    public FilmeBuilder comID(int id){
        filme.setId(id);
        return this;
    }
    public FilmeBuilder comLancamentoEm(LocalDate lancamento){
        filme.setDataDeLancamento(lancamento);
        return this;
    }
    public FilmeBuilder comDescricao(String descricao){
        filme.setDescricao(descricao);
        return this;
    }
    public FilmeBuilder comOrcamento(BigDecimal orcamento){
        filme.setOrcamento(orcamento);
        return this;
    }

    public FilmeBuilder comAtores(List<Ator> atores){
        filme.setAtores(atores);
        return this;
    }
    public FilmeBuilder comDiretores(List<Diretor> diretores){
        filme.setDiretores(diretores);
        return this;
    }

    public Filme build(){
        return filme;
    }
}
