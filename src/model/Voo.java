package model;

import org.jetbrains.annotations.NotNull;
import repositorio.RepositorioVoo;

import java.time.*;

public class Voo {
    private String status;
    private final int id;
    private Aeroporto origem;
    private Aeroporto destino;
    private double distancia;
    private Aviao aviao;
    private LocalDateTime dataSaida;
    private LocalDateTime dataChegada;
    private int vagas1classe;
    private int vagasClasseExecutiva;
    private int vagasClasseEconomica;

    public Voo(@NotNull Aeroporto origem, @NotNull Aeroporto destino,@NotNull Aviao aviao, int ano, int mes, int dia, int hora, int minuto){
        this.status = "Agendado";
        this.id = IdGenerator.nextID("voo");
        this.origem = origem;
        this.destino = destino;
        this.distancia = calcularDistancia(origem.getLocalizacao(),destino.getLocalizacao());
        this.aviao = aviao;
        this.dataSaida = LocalDateTime.of(ano,mes,dia,hora,minuto);
        this.dataChegada = calcularDataChegada(dataSaida);
        this.vagas1classe = aviao.getCapacidadePassageiros(0);
        this.vagasClasseExecutiva = aviao.getCapacidadePassageiros(1);
        RepositorioVoo.adicionarVoo(this);
    }

    public boolean adiarVoo(int ano,int mes,int dia,int hora,int minuto){
        LocalDateTime data = LocalDateTime.of(ano,mes,dia,hora,minuto);
        if (data.isAfter(dataSaida) && LocalDateTime.now().isBefore(dataSaida)){
            this.dataSaida = data;
            this.dataChegada = calcularDataChegada(dataSaida);
            this.status = "Adiado para: "+ dataSaida;
            return true;
        }
        return false;
    }

    public void cancelarVoo(){
        this.status = "Cancelado";
    }

    private LocalDateTime calcularDataChegada(LocalDateTime dataSaida){
        double velocidade = aviao.velocidadeCruzeiro;
        double tempo = distancia / velocidade;
        tempo *= 60;
        return dataSaida.plusMinutes((int) tempo);
    }

    private double calcularDistancia(Localizacao origem,Localizacao destino){
        return origem.calcularDistancia(destino);
    }

    public int ocuparVaga(int classe){
        switch (classe){
            case 0:
                vagasClasseEconomica--;
            case 1:
                vagasClasseExecutiva--;
            case 2:
                vagas1classe--;
        }
        return 0;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getVagas1classe() {
        return vagas1classe;
    }

    public int getVagasClasseExecutiva() {
        return vagasClasseExecutiva;
    }

    public int getVagasClasseEconomica(){
        return vagasClasseEconomica;
    }

    public int getId() {
        return id;
    }

    public Aeroporto getOrigem() {
        return origem;
    }

    public Aeroporto getDestino() {
        return destino;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public LocalDateTime getDataChegada() {
        return dataChegada;
    }

    public double getDistancia(){
        return distancia;
    }
}