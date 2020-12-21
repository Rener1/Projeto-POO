import java.time.*;

public class Voo {
    private String status;
    private int id;
    private Aeroporto origem;
    private Aeroporto destino;
    private Aviao aviao;
    private LocalDateTime dataSaida;
    private LocalDateTime dataChegada;
    private int vagas;

    Voo(int id, Aeroporto origem, Aeroporto destino, Aviao aviao, int ano, int mes, int dia, int hora, int minutos){
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.aviao = aviao;
        this.dataSaida = LocalDateTime.of(ano,mes,dia,hora,minutos);
    }

    public void adiarVoo(){}
    public void cancelarVoo(){}
}