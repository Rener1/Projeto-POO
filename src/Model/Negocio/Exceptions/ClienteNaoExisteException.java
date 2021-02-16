package Model.Negocio.Exceptions;

public class ClienteNaoExisteException extends Exception{
    private String cpf;

    public ClienteNaoExisteException(String cpf) {
        super("Este cliente não existe!");
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
