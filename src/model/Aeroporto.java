package model;

public class Aeroporto {
    private String nome;
    private Localizacao localizacao;

    public Aeroporto(String nome,String cidade,String estado,char dirLat,int gLat,int mLat,double sLat,char dirLong,int gLong,int mLong,double sLong){
        this.nome = nome;
        this.localizacao = new Localizacao(cidade,estado,dirLat,gLat,mLat,sLat,dirLong,gLong,mLong,sLong);
    }

    public Localizacao getLocalizacao(){
        return localizacao;
    }

    public String getNome(){
        return nome;
    }
}
