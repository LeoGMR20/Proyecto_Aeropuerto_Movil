package com.example.proyecto_aeropuerto;

public class Vuelo {

    //Atributos

    private int codVuelo;
    private String origen;
    private String destino;
    private String nitAerolinea;
    private boolean internacional;
    private String clase;

    public Vuelo(int codVuelo, String origen, String destino, String nitAerolinea, boolean internacional, String clase) {
        this.codVuelo = codVuelo;
        this.origen = origen;
        this.destino = destino;
        this.nitAerolinea = nitAerolinea;
        this.internacional = internacional;
        this.clase = clase;
    }

    public int getCodVuelo() {
        return codVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getNitAerolinea() {
        return nitAerolinea;
    }

    public boolean isInternacional() {
        return internacional;
    }

    public String getClase() {
        return clase;
    }
}
