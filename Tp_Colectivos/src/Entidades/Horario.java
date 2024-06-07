/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.time.LocalTime;

/**
 *
 * @author Lucas
 */
public class Horario {
    private int idHorario;
    private Ruta idRuta;
    private LocalTime hora_salida;
    private LocalTime hora_llegada;
    private boolean estado;

    public Horario() {
    }

    public Horario(int idHorario, Ruta idRuta, LocalTime hora_salida, LocalTime hora_llegada, boolean estado) {
        this.idHorario = idHorario;
        this.idRuta = idRuta;
        this.hora_salida = hora_salida;
        this.hora_llegada = hora_llegada;
        this.estado = estado;
    }

    public Horario(Ruta idRuta, LocalTime hora_salida, LocalTime hora_llegada, boolean estado) {
        this.idRuta = idRuta;
        this.hora_salida = hora_salida;
        this.hora_llegada = hora_llegada;
        this.estado = estado;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public Ruta getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Ruta idRuta) {
        this.idRuta = idRuta;
    }

    public LocalTime getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(LocalTime hora_salida) {
        this.hora_salida = hora_salida;
    }

    public LocalTime getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(LocalTime hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return idRuta.getOrigen()+" "+hora_salida+" "+idRuta.getDestino()+" "+hora_llegada;
    }
    
    
}
