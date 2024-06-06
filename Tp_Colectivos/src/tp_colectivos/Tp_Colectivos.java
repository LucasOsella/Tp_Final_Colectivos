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
        
    Ruta r1 = new Ruta("San Luis", "La Toma", LocalTime.of(1, 0), true);
//    
//    Ruta r2 = new Ruta("La Toma","San Luis" , LocalTime.of(1, 0), true);
    RutaData rd = new RutaData();
//    rd.agregarRuta(r2);
//    
//    rd.agregarRuta(r1);
      Ruta r2=rd.buscarRutaPorId(2);
        
        
        HorariosData hd=new HorariosData();
        Horario horario=new Horario(r1,LocalTime.of(19,0),LocalTime.of(20, 0),true);
        Horario horario_2=new Horario(r2,LocalTime.of(15,0),LocalTime.of(16, 0),true);
            
//          hd.añadirHorario(horario);
//          hd.añadirHorario(horario_2);

        System.out.println("Listar todas las rutas");
        List<Horario>horarios=hd.obtenerHorarios();
        System.out.println(horarios);
    
        List<Horario>horarios_porRuta=hd.listarHorariosPorRuta(2);
        System.out.println("Horario por Ruta id");
        System.out.println(horarios_porRuta);
        
        Pasajero pas=new Pasajero ("Lucas","Osella","43282117","lucasosella01@gmail.com","2664506790",true);
        PasajerosData pd= new PasajerosData();
//    pd.añadirPasajero(pas);

//    List pasajeros=pd.listarPasajero();
//        System.out.println(pasajeros);

//    List<Ruta> rutas=rd.listarRuta();
//        System.out.println(rutas);
    System.out.println("Apellido");
        System.out.println(pd.buscarPasajeroPorApellido("Osella"));
        System.out.println("Nombre");
        System.out.println(pd.buscarPasjeroPorNombre("Lucas"));
        System.out.println("Dni");
        System.out.println(pd.buscarPasajeroPorDni("43282117"));
       
            
    }
    
}
