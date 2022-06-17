package com.example.proyecto_aeropuerto;

import java.util.Date;

public class Pasajero {
    private int idPasajero;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private String tipoDocumento;
    private String numDocumento;
    private Date fecha_nac;

    public Pasajero(int idPasajero, String nombres, String apellido_paterno, String apellido_materno, String tipoDocumento, String numDocumento, Date fecha_nac) {
        this.idPasajero = idPasajero;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.fecha_nac = fecha_nac;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }
}
