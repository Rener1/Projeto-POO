package repositorio;

import model.Aeroporto;
import java.util.ArrayList;

public class RepositorioAeroporto {
    private static final ArrayList<Aeroporto> aeroportos = new ArrayList<>();

    public static void adicionarAeroporto(Aeroporto aeroporto){
        aeroportos.add(aeroporto);
    }

    public static Aeroporto verificarAeroporto(int id){
        for (Aeroporto aeroporto: aeroportos){
            if (aeroporto.getId() == id){
                return aeroporto;
            }
        }
        return null;
    }
}
