package repositorio;

import model.Aeroporto;
import java.util.ArrayList;

public class repositorioAeroporto {
    ArrayList<Aeroporto> aeroportos = new ArrayList<>();

    public void adicionarAeroporto(String nome,String cidade,String estado,char dirLat,int gLat,int mLat,double sLat,char dirLong,int gLong,int mLong,double sLong){
        Aeroporto aeroporto = new Aeroporto(nome,cidade,estado,dirLat,gLat,mLat,sLat,dirLong,gLong,mLong,sLong);
        aeroportos.add(aeroporto);
    }

    public Aeroporto verificarAeroporto(String nome){
        for (Aeroporto aeroporto: aeroportos){
            if (aeroporto.getNome().equals(nome)){
                return aeroporto;
            }
        }
        return null;
    }
}
