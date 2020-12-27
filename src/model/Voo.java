package model;

import org.jetbrains.annotations.NotNull;
import repositorio.RepositorioVoo;

import java.time.*;

public class Voo {
    private String status;
    private int id;
    private Aeroporto origem;
    private Aeroporto destino;
    private Aviao aviao;
    private LocalDateTime dataSaida;
    private LocalDateTime dataChegada;
    private int vagas1classe;
    private int vagas2classe;

    public Voo(int id, @NotNull Aeroporto origem, @NotNull Aeroporto destino,@NotNull Aviao aviao, int ano, int mes, int dia, int hora, int minuto){
        this.status = "Agendado";
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.aviao = aviao;
        this.dataSaida = LocalDateTime.of(ano,mes,dia,hora,minuto);
        this.dataChegada = calcularDataChegada(dataSaida);
        this.vagas1classe = aviao.getCapacidadePassageiros(0);
        this.vagas2classe = aviao.getCapacidadePassageiros(1);
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
        double distancia = origem.getLocalizacao().calcularDistancia(destino.getLocalizacao());
        double velocidade = aviao.velocidadeCruzeiro;
        double tempo = distancia / velocidade;
        tempo *= 60;
        LocalDateTime horaChegada = dataSaida.plusMinutes((int) tempo);
        return horaChegada;
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

    public void setVagas1classe(int vagas1classe) {
        this.vagas1classe = vagas1classe;
    }

    public int getVagas2classe() {
        return vagas2classe;
    }

    public void setVagas2classe(int vagas2classe) {
        this.vagas2classe = vagas2classe;
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
}