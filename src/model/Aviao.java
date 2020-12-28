package model;

import org.jetbrains.annotations.NotNull;
import repositorio.RepositorioAviao;

public abstract class Aviao {
    protected String modelo;
    protected final int id;
    protected String status;
    protected Voo voo;
    protected double velocidadeCruzeiro;
    protected int[] capacidadePassageiros = new int[3];
    protected Localizacao localizacao;

    public Aviao(@NotNull Localizacao localizacao){
        this.id = IdGenerator.nextID("aviao");
        this.voo = null;
        this.status = "Parado";
        this.localizacao = localizacao;
        RepositorioAviao.adicionarAviao(this);
    }

    public void voar(Voo voo){
        this.voo = voo;
        this.status = "Em voo";
    }
    public int getId(){
        return id;
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

    public String getStatus() {
        return status;
    }

    public Voo getVoo() {
        return voo;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao){
        this.localizacao = localizacao;
    }
}
