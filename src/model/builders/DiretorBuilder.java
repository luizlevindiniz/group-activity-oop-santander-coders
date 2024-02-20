package model.builders;

import model.Diretor;

public class DiretorBuilder {
        private final Diretor diretor = new Diretor();

        public DiretorBuilder comID(int id){
            diretor.setId(id);
            return this;
        }
        public DiretorBuilder comNome(String nome){
            diretor.setNome(nome);
            return this;
        }

        public Diretor build(){
            return diretor;
        }


}


