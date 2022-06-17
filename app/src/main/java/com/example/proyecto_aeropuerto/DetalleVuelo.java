package com.example.proyecto_aeropuerto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class DetalleVuelo implements Serializable {

    private int idDetalle;
    private int codAvion;
    private Vuelo codVuelo;
    private float precio;
    private Time horaSalida;
    private Time horaLlegada;
    private Date fechaSalida;
    private Date fechaLlegada;
    private String puertaEmbarque;
    private String estado;

    public DetalleVuelo(int idDetalle, int codAvion, Vuelo codVuelo, float precio, Time horaSalida,
                        Time horaLlegada, Date fechaSalida, Date fechaLlegada,
                        String puertaEmbarque, String estado) {
        this.idDetalle = idDetalle;
        this.codAvion = codAvion;
        this.codVuelo = codVuelo;
        this.precio = precio;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.puertaEmbarque = puertaEmbarque;
        this.estado = estado;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public int getCodAvion() {
        return codAvion;
    }

    public Vuelo getCodVuelo() {
        return codVuelo;
    }

    public float getPrecio() {
        return precio;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public Time getHoraLlegada() {
        return horaLlegada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public String getPuertaEmbarque() {
        return puertaEmbarque;
    }

    public String getEstado() {
        return estado;
    }
}
