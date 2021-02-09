package model;

public class Localizacao {
    private String cidade;
    private String estado;
    private Coordenada latitude;
    private Coordenada longetude;

    public Localizacao(String cidade, String estado,Coordenada latitude,Coordenada longetude){
        this.cidade = cidade;
        this.estado = estado;
        this.latitude = latitude;
        this.longetude = longetude;
    }

    public double calcularDistancia(Localizacao lugarDestino){
        return Math.sqrt(Math.pow(latitude.distanciaEntreCoordenadas(lugarDestino.latitude),2) + Math.pow(longetude.distanciaEntreCoordenadas(lugarDestino.longetude),2));
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }
}
