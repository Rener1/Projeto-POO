package model;

import repositorio.RepositorioAeroporto;

public class Aeroporto {
    private String nome;
    private Localizacao localizacao;
    private final int id;

    public Aeroporto(String nome,Localizacao localizacao){
        this.nome = nome;
        this.id = IdGenerator.nextID("aeroporto");
        this.localizacao = localizacao;
        RepositorioAeroporto.adicionarAeroporto(this);
    }

    public Localizacao getLocalizacao(){
        return localizacao;
    }

    public int getId() {
        return id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
