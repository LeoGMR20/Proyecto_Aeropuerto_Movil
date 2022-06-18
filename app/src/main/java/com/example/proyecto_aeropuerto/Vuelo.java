package com.example.proyecto_aeropuerto;

import java.io.Serializable;
import java.sql.Time;

public class Vuelo implements Serializable {

    //Atributos

    private String aerolinea;
    private String horaSalida;
    private String horaLlegada;
    private int codVuelo;
    private String ciudad;
    private Double precio;

    public Vuelo(String aerolinea, String horaSalida, String horaLlegada, int codVuelo, String ciudad, Double precio) {
        this.aerolinea = aerolinea;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.codVuelo = codVuelo;
        this.ciudad = ciudad;
        this.precio = precio;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public int getCodVuelo() {
        return codVuelo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Double getPrecio() {
        return precio;
    }
}
