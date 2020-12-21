public class Localizacao {
    private String cidade;
    private String estado;
    private Coordenada latitude;
    private Coordenada longetude;

    Localizacao(String cidade, String estado,char dirLat, int gLat, int mLat, double sLat, char dirLong, int gLong, int mLong, double sLong){
        this.cidade = cidade;
        this.estado = estado;
        this.latitude = new Coordenada(gLat,mLat,sLat,dirLat);
        this.longetude = new Coordenada(gLong,mLong,sLong,dirLong);
    }

    public double calcularDistancia(Localizacao lugarDestino){
        return Math.sqrt(Math.pow(this.latitude.distanciaEntreCoordenadas(lugarDestino.latitude),2) + Math.pow(this.longetude.distanciaEntreCoordenadas(lugarDestino.longetude),2));
    }
}
