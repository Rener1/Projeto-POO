package Model.Dados.Repositorios;

import Model.Negocio.Cliente;
import Model.Dados.Interfaces.IRepositorioClientes;
import java.util.ArrayList;

public class RepositorioClientes implements IRepositorioClientes {
    private ArrayList<Cliente> clientes;

    RepositorioClientes() {
        this.clientes = new ArrayList<Cliente>();
    }

    @Override
    public void adicionar(Cliente cliente){
        clientes.add(cliente);
    }

    @Override
    public Cliente consultar(String cpf){
        for (Cliente cliente: clientes){
            if (cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        return null;
    }

    @Override
    public void remover(Cliente cliente){
        clientes.remove(cliente);
    }
}
