package model;

public class AtorBuilder {
    private final Ator ator = new Ator();

    public AtorBuilder comID(int id){
        ator.setId(id);
        return this;
    }
    public AtorBuilder comNome(String nome){
        ator.setNome(nome);
        return this;
    }

    public Ator build(){
        return ator;
    }
}
