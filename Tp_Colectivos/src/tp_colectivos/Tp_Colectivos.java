/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_colectivos;

import AccesosDatos.RutaData;
import Entidades.Ruta;
import java.time.LocalTime;

/**
 *
 * @author Lucas
 */
public class Tp_Colectivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    Ruta r1 = new Ruta("San Luis", "La Toma", LocalTime.of(1, 0), true);
    
    RutaData rd = new RutaData();
    
    rd.agregarRuta(r1);
        
    }
    
}
