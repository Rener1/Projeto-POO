package Model.Negocio;

import Model.Negocio.Exceptions.ClasseLotadaException;
import Model.Negocio.Exceptions.DataInvalidaException;
import org.jetbrains.annotations.NotNull;
import Model.Dados.Repositorios.RepositorioVoos;
import java.time.*;
import java.util.ArrayList;

public class Voo {
    private String status;
    private final int id;
    private Aeroporto origem;
    private Aeroporto destino;
    private double distancia;
    private Aviao aviao;
    private LocalDateTime dataSaida;
    private LocalDateTime dataChegada;
    private int[] vagas = new int[3];
    private int[] assento = new int[3];
    private boolean[] lotado = new boolean[3];
    private double precoBase;
    private ArrayList<Passagem> passagens;

    public Voo(@NotNull Aeroporto origem, @NotNull Aeroporto destino,@NotNull Aviao aviao,LocalDateTime data) throws DataInvalidaException {
        if (data.isBefore(LocalDateTime.now())) {
            throw new DataInvalidaException(LocalDateTime.now(),data);
        }
        this.status = "Agendado";
        this.id = IdGenerator.nextID("voo");
        this.origem = origem;
        this.destino = destino;
        this.distancia = calcularDistancia(origem.getLocalizacao(),destino.getLocalizacao());
        this.aviao = aviao;
        this.dataSaida = data;
        this.dataChegada = calcularDataChegada(dataSaida);
        this.vagas[0] = aviao.getCapacidadePassageiros(0);
        this.vagas[1] = aviao.getCapacidadePassageiros(1);
        this.vagas[2] = aviao.getCapacidadePassageiros(2);
        this.assento[1] = vagas[0];
        this.assento[2] = vagas[0] + vagas[1];
        this.precoBase = calcularPreco();
        this.passagens = new ArrayList<>();
        RepositorioVoos.adicionarVoo(this);
    }

    public boolean adiarVoo(LocalDateTime data){
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

    private double calcularPreco(){
        precoBase = 100;
        precoBase += distancia * 0.03;
        return precoBase;
    }

    public Passagem gerarPassagem(Cliente cliente,int classe) throws ClasseLotadaException {
        if (isLotado(classe)) {
            throw new ClasseLotadaException(this,classe);
        }
        return new Passagem(cliente, this,classe);
    }

    public int ocuparVaga(Passagem passagem,int classe){
        vagas[classe]--;
        assento[classe]++;
        passagens.add(passagem);
        if (vagas[classe] == 0){
            lotado[classe] = true;
        }
        return assento[classe];
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getVagas(int classe) {
        return vagas[classe];
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

    public double getPrecoBase() {
        return precoBase;
    }

    public boolean isLotado(int classe) {
        return lotado[classe];
    }
}