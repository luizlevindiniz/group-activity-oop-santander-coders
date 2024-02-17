package model;

public class DiretorBuilder {
        private final Diretor diretor = new Diretor();

        public model.DiretorBuilder comID(int id){
            diretor.setId(id);
            return this;
        }
        public model.DiretorBuilder comNome(String nome){
            diretor.setNome(nome);
            return this;
        }

        public Diretor build(){
            return diretor;
        }


}


