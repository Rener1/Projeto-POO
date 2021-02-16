package Model.Negocio;

import Model.Dados.Interfaces.IRepositorioClientes;
import Model.Negocio.Exceptions.ClienteJaExisteException;
import Model.Negocio.Exceptions.ClienteNaoExisteException;

public class NegocioCliente {
    private IRepositorioClientes repositorio;

    NegocioCliente(IRepositorioClientes repositorio) {
        this.repositorio = repositorio;
    }

    public void adicionar(Cliente cliente) throws ClienteJaExisteException {
        if (repositorio.consultar(cliente.getCpf()) != null) {
            throw new ClienteJaExisteException(cliente.getCpf());
        }
        else {
            repositorio.adicionar(cliente);
        }
    }

    public void remover(String cpf) throws ClienteNaoExisteException {
        Cliente c = repositorio.consultar(cpf);
        if(c == null) {
            throw new ClienteNaoExisteException(cpf);
        }
        else {
            repositorio.remover(c);
        }
    }
}