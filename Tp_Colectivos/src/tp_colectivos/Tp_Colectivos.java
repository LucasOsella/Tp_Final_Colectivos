/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_colectivos;

import AccesosDatos.*;
import Entidades.*;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class Tp_Colectivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    Ruta r1 = new Ruta(1,"San Luis", "La Toma", LocalTime.of(1, 0), true);
//    
    RutaData rd = new RutaData();
//    
//    rd.agregarRuta(r1);
        HorariosData hd=new HorariosData();
        Horario horario=new Horario(r1,LocalTime.of(19,0),LocalTime.of(20, 0),true);
            
//        hd.añadirHorario(horario);

    Pasajero pas=new Pasajero ("Lucas","Osella","43282117","lucasosella01@gmail.com","2664506790",true);
    PasajerosData pd= new PasajerosData();
//    pd.añadirPasajero(pas);

    List pasajeros=pd.listarPasajero();
        System.out.println(pasajeros);
    }
    
}
