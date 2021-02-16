package Model.Negocio;

public class IdGenerator {
    private static int idAeroporto = -1;
    private static int idAviao = -1;
    private static int idVoo = -1;

    public static int nextID(String tipo){
        switch (tipo){
            case "aeroporto":
                idAeroporto++;
                return idAeroporto;
            case "aviao":
                idAviao++;
                return idAviao;
            case "voo":
                idVoo++;
                return idVoo;
            default:
                return -1;
        }
    }
}
