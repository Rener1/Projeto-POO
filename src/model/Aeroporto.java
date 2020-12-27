package model;

public class Aeroporto {
    private String nome;
    private Localizacao localizacao;

    public Aeroporto(String nome, Localizacao localizacao){
        this.nome = nome;
        this.localizacao = localizacao;
    }

    public Localizacao getLocalizacao(){
        return localizacao;
    }

    public String getNome(){
        return nome;
    }
}
