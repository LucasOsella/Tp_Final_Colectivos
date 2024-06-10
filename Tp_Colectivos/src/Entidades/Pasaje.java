/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;


import java.time.*;

/**
 *
 * @author Lucas
 */
public class Pasaje {
    private int idPasaje;
    private Pasajero idPasajero;
    private Colectivo idColectivo;
    private Ruta idRuta;
    private LocalDate fechaViaje;
    private LocalTime horaViaje;
    private int asiento;
    private double precio;

    public Pasaje() {
    }

    public Pasaje(int idPasaje, Pasajero idPasajero, Colectivo idColectivo, Ruta idRuta, LocalDate fechaViaje, LocalTime horaViaje, int asiento, double precio) {
        this.idPasaje = idPasaje;
        this.idPasajero = idPasajero;
        this.idColectivo = idColectivo;
        this.idRuta = idRuta;
        this.fechaViaje = fechaViaje;
        this.horaViaje = horaViaje;
        this.asiento = asiento;
        this.precio = precio;
    }

    public Pasaje(Pasajero idPasajero, Colectivo idColectivo, Ruta idRuta, LocalDate fechaViaje, LocalTime horaViaje, int asiento, double precio) {
        this.idPasajero = idPasajero;
        this.idColectivo = idColectivo;
        this.idRuta = idRuta;
        this.fechaViaje = fechaViaje;
        this.horaViaje = horaViaje;
        this.asiento = asiento;
        this.precio = precio;
    }

    public int getIdPasaje() {
        return idPasaje;
    }

    public void setIdPasaje(int idPasaje) {
        this.idPasaje = idPasaje;
    }

    public Pasajero getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(Pasajero idPasajero) {
        this.idPasajero = idPasajero;
    }

    public Colectivo getIdColectivo() {
        return idColectivo;
    }

    public void setIdColectivo(Colectivo idColectivo) {
        this.idColectivo = idColectivo;
    }

    public Ruta getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Ruta idRuta) {
        this.idRuta = idRuta;
    }

    public LocalDate getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(LocalDate fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public LocalTime getHoraViaje() {
        return horaViaje;
    }

    public void setHoraViaje(LocalTime horaViaje) {
        this.horaViaje = horaViaje;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Pasaje{" + "idPasaje=" + idPasaje + ", idPasajero=" + idPasajero + ", idColectivo=" + idColectivo + ", idRuta=" + idRuta + ", fechaViaje=" + fechaViaje + ", horaViaje=" + horaViaje + ", asiento=" + asiento + ", precio=" + precio + '}';
    }
    
    
}
