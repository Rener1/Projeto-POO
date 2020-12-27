package repositorio;

import model.Aeroporto;
import java.util.ArrayList;

public class RepositorioAeroporto {
    private static ArrayList<Aeroporto> aeroportos = new ArrayList<>();

    public static void adicionarAeroporto(Aeroporto aeroporto){
        aeroportos.add(aeroporto);
    }

    public static Aeroporto verificarAeroporto(String nome){
        for (Aeroporto aeroporto: aeroportos){
            if (aeroporto.getNome().equals(nome)){
                return aeroporto;
            }
        }
        return null;
    }
}
