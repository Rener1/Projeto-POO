package Model.Negocio.Exceptions;

import java.time.LocalDateTime;

public class DataInvalidaException extends Exception{
    LocalDateTime dataAtual;
    LocalDateTime dataTentativa;

    public DataInvalidaException(LocalDateTime dataAtual, LocalDateTime dataTentativa){
        super("Não é possível criar um voo para esta data!");
        this.dataAtual = dataAtual;
        this.dataTentativa = dataTentativa;
    }

    public LocalDateTime getDataAtual() {
        return dataAtual;
    }

    public LocalDateTime getDataTentativa() {
        return dataTentativa;
    }
}
