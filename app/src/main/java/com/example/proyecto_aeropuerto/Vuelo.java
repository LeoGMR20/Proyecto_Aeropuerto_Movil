package com.example.proyecto_aeropuerto;

import java.io.Serializable;

public class Vuelo implements Serializable {

    //Atributos

    private int codVuelo;
    private int origen;
    private int destino;
    private String nitAerolinea;
    private boolean internacional;

    public Vuelo(int codVuelo, int origen, int destino, String nitAerolinea, boolean internacional) {
        this.codVuelo = codVuelo;
        this.origen = origen;
        this.destino = destino;
        this.nitAerolinea = nitAerolinea;
        this.internacional = internacional;
    }

    public int getCodVuelo() {
        return codVuelo;
    }

    public int getOrigen() {
        return origen;
    }

    public int getDestino() {
        return destino;
    }

    public String getNitAerolinea() {
        return nitAerolinea;
    }

    public boolean isInternacional() {
        return internacional;
    }
}
