package AccesosDatos;


import Entidades.Pasaje;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class VentasData {

private Connection con = null;
private HorariosData horario = new HorariosData();
private RutaData ruta = new RutaData();
private PasajerosData pasajero = new PasajerosData();
private ColectivoData colectivo = new ColectivoData();

public VentasData(){
con = Conexion.getConexion();
}

public void registrarVenta(Pasaje pasaje){

String sql = "INSERT INTO `pasaje`(`idPasajero`, `idColectivo`, `idRuta`, `fechaviaje`, `horaviaje`, `asiento`, `precio`) VALUES (?,?,?,?,?,?,?)";
Time hora_viaje = Time.valueOf(pasaje.getHoraViaje());
Date fecha_viaje = Date.valueOf(pasaje.getFechaViaje());
try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pasaje.getIdPasajero().getIdPasajero());
            ps.setInt(2, pasaje.getIdColectivo().getIdColectivo());
            ps.setInt(3, pasaje.getIdRuta().getIdRuta());
            ps.setDate(4, fecha_viaje);
            ps.setTime(5, hora_viaje);
          
            ps.setInt(6, pasaje.getAsiento());
            ps.setDouble(7, pasaje.getPrecio());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
                pasaje.setIdPasaje(rs.getInt("idPasaje"));
                JOptionPane.showMessageDialog(null, "Pasaje añadido con exito numero de pasje "+pasaje.getIdPasaje());
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder al tabla pasaje "+e.getMessage());
        }        
    }
    public List<Pasaje> verPasajes(){
    String sql = "SELECT `idPasaje`, `idPasajero`, `idColectivo`, `idRuta`, `fechaviaje`, `horaviaje`, `asiento`, `precio` FROM `pasaje` WHERE 1";
    List<Pasaje> pasajes = new ArrayList();
     try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
               Pasaje pasaje =new Pasaje();
               pasaje.setIdPasaje(rs.getInt("idPasaje"));
               pasaje.setIdPasajero(pasajero.buscarPasajeroPorID(rs.getInt("idPasajero")));
               pasaje.setIdColectivo(colectivo.buscarColectivoPorID(rs.getInt("idColectivo")));
               pasaje.setIdRuta(ruta.buscarRutaPorId(rs.getInt("idRuta")));
               pasaje.setFechaViaje(rs.getDate("fechaviaje").toLocalDate());
               pasaje.setHoraViaje(rs.getTime("horaviaje").toLocalTime());
               pasaje.setAsiento(rs.getInt("asiento"));
               pasaje.setPrecio(rs.getDouble("precio"));
               
               pasajes.add(pasaje);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Inscripcion");
        }
        return pasajes;
    
    }
    
     public List<Pasaje> historialPasajesPorRuta(int id){
    String sql = "SELECT * FROM `pasaje` WHERE idRuta = ?";
    List<Pasaje> pasajes = new ArrayList();
     try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
               Pasaje pasaje =new Pasaje();
               pasaje.setIdPasaje(rs.getInt("idPasaje"));
               pasaje.setIdPasajero(pasajero.buscarPasajeroPorID(rs.getInt("idPasajero")));
               pasaje.setIdColectivo(colectivo.buscarColectivoPorID(rs.getInt("idColectivo")));
               pasaje.setIdRuta(ruta.buscarRutaPorId(rs.getInt("idRuta")));
               pasaje.setFechaViaje(rs.getDate("fechaviaje").toLocalDate());
               pasaje.setHoraViaje(rs.getTime("horaviaje").toLocalTime());
               pasaje.setAsiento(rs.getInt("asiento"));
               pasaje.setPrecio(rs.getDouble("precio"));
               
               pasajes.add(pasaje);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Inscripcion");
        }
        return pasajes;
    
    }
     
    public List<Pasaje> historialPasajesPorHorario(LocalTime hora){
    String sql = "SELECT * FROM `pasaje` WHERE horaviaje = ?";
    List<Pasaje> pasajes = new ArrayList();
     try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setTime(1, Time.valueOf(hora));
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {                
               Pasaje pasaje =new Pasaje();
               pasaje.setIdPasaje(rs.getInt("idPasaje"));
               pasaje.setIdPasajero(pasajero.buscarPasajeroPorID(rs.getInt("idPasajero")));
               pasaje.setIdColectivo(colectivo.buscarColectivoPorID(rs.getInt("idColectivo")));
               pasaje.setIdRuta(ruta.buscarRutaPorId(rs.getInt("idRuta")));
               pasaje.setFechaViaje(rs.getDate("fechaviaje").toLocalDate());
               pasaje.setHoraViaje(rs.getTime("horaviaje").toLocalTime());
               pasaje.setAsiento(rs.getInt("asiento"));
               pasaje.setPrecio(rs.getDouble("precio"));
               
               pasajes.add(pasaje);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla pasajes"+e.getMessage());
        }
        return pasajes;
    
    } 
     
     public List<Pasaje> historialPasajesPorPasajero(int id){
    String sql = "SELECT * FROM `pasaje` WHERE idPasajero = ?";
    List<Pasaje> pasajes = new ArrayList();
     try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
               Pasaje pasaje =new Pasaje();
               pasaje.setIdPasaje(rs.getInt("idPasaje"));
               pasaje.setIdPasajero(pasajero.buscarPasajeroPorID(rs.getInt("idPasajero")));
               pasaje.setIdColectivo(colectivo.buscarColectivoPorID(rs.getInt("idColectivo")));
               pasaje.setIdRuta(ruta.buscarRutaPorId(rs.getInt("idRuta")));
               pasaje.setFechaViaje(rs.getDate("fechaviaje").toLocalDate());
               pasaje.setHoraViaje(rs.getTime("horaviaje").toLocalTime());
               pasaje.setAsiento(rs.getInt("asiento"));
               pasaje.setPrecio(rs.getDouble("precio"));
               
               pasajes.add(pasaje);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla pasajes");
        }
        return pasajes;
    
    } 
     public void borrarPasaje(int id){
     String sql = "DELETE FROM `pasaje` WHERE idPasaje =?";
     try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if(filas > 0){
               JOptionPane.showMessageDialog(null,"Pasaje Borrado.");   
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla Pasajes.");
        }
     
     }
     
     public Pasaje mostrarRecibo(int id){
        String sql = "SELECT `idPasaje`, `idPasajero`, `idColectivo`, `idRuta`, `fechaviaje`, `horaviaje`, `asiento`, `precio` FROM `pasaje` WHERE idPasaje = ?";
        Pasaje pasaje = new Pasaje();
     try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
               pasaje.setIdPasaje(rs.getInt("idPasaje"));
               pasaje.setIdPasajero(pasajero.buscarPasajeroPorID(rs.getInt("idPasajero")));
               pasaje.setIdColectivo(colectivo.buscarColectivoPorID(rs.getInt("idColectivo")));
               pasaje.setIdRuta(ruta.buscarRutaPorId(rs.getInt("idRuta")));
               pasaje.setFechaViaje(rs.getDate("fechaviaje").toLocalDate());
               pasaje.setHoraViaje(rs.getTime("horaviaje").toLocalTime());
               pasaje.setAsiento(rs.getInt("asiento"));
               pasaje.setPrecio(rs.getDouble("precio"));
            
             
            }
              ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puedo acceder a la tabla y traer al alumno por nombre");
        }
        return pasaje;
    
    }
     }

    

