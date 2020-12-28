package model;

import repositorio.RepositorioAeroporto;

public class Aeroporto {
    private String nome;
    private Localizacao localizacao;
    private final int id;

    public Aeroporto(String nome,String cidade,String estado,char dirLat,int gLat,int mLat,double sLat,char dirLong,int gLong,int mLong,double sLong){
        this.nome = nome;
        this.id = IdGenerator.nextID("aeroporto");
        this.localizacao = new Localizacao(cidade,estado,dirLat,gLat,mLat,sLat,dirLong,gLong,mLong,sLong);
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
