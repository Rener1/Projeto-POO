package repositorio;

import model.Cliente;
import java.util.ArrayList;

public class RepositorioCliente {
    private static final ArrayList<Cliente> clientes = new ArrayList<>();

    public static void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public static Cliente verificarCliente(String cpf){
        for (Cliente cliente: clientes){
            if (cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        return null;
    }

    public static void atualizarCliente(String cpf, String nome){
        Cliente cliente = verificarCliente(cpf);
        if (cliente != null) {
            cliente.setNome(nome);
        }
    }

    public static void deletarCliente(String cpf){
        Cliente cliente = verificarCliente(cpf);
        clientes.remove(cliente);
    }
}
