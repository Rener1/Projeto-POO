package Model.Negocio.Exceptions;

import Model.Negocio.Cliente;

public class ClienteJaExisteException extends Exception{
    private String cpf;

    public ClienteJaExisteException(String cpf) {
        super("Este cliente já foi cadastrado!");
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
