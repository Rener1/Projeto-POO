package model;

public abstract class Aviao {
    protected String modelo;
    protected String status;
    protected double velocidadeCruzeiro;
    protected int[] capacidadePassageiros = new int[2];
    protected Localizacao localizacao;


    public void voar(){

    }

    public String getModelo() {
        return modelo;
    }

    public double getVelocidadeCruzeiro() {
        return velocidadeCruzeiro;
    }

    public int getCapacidadePassageiros(int classe) {
        return capacidadePassageiros[classe];
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao){
        this.localizacao = localizacao;
    }
}
