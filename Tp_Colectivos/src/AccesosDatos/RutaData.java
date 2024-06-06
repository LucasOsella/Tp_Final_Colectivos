package AccesosDatos;

import Entidades.Ruta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class RutaData {
    private Connection con=null;

    public RutaData() {
        con=Conexion.getConexion();
    }   
        
    public void agregarRuta(Ruta ruta){
    String sql = "INSERT INTO `ruta`( `origen`, `destino`, `duracion_estimada`, `estado`)VALUES (?,?,?,?) ";
    Time duracion_estimada = Time.valueOf(ruta.getDuracion_estimadad());
    try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ruta.getOrigen());
            ps.setString(2, ruta.getDestino());
            ps.setTime(3,duracion_estimada);
            ps.setBoolean(4, ruta.isEstado());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
                ruta.setIdRuta(rs.getInt("IdRuta"));
                JOptionPane.showMessageDialog(null, "Ruta añadida con exito");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder al tabla Ruta "+e.getMessage());
        }        
    }
      public List<Ruta> listarRuta(){
      List<Ruta> rutas = new ArrayList<>();
      String sql = "SELECT `idRuta`, `origen`, `destino`, `duracion_estimada` FROM `ruta` WHERE estado = 1 ";
       try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){   
               Ruta ruta=new Ruta();
               Time duracion_estimada = Time.valueOf(ruta.getDuracion_estimadad());
               ruta.setIdRuta(rs.getInt("idRuta"));
               ruta.setOrigen(rs.getString("origen"));
               ruta.setDestino(rs.getString("destino"));
               ruta.setDuracion_estimadad(rs.getTime("duracion_estimada").toLocalTime());
               rutas.add(ruta);                                            
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puedo acceder a la tabla ruta");
        }
        return rutas; 
      }
        
    
    public Ruta buscarRutaPorOrigen(String origen){
    Ruta ruta = null;
    String sql = "SELECT `idRuta`, `origen`, `destino`, `duracion_estimada` FROM `ruta` WHERE origen = ? and estado = 1 ";
    PreparedStatement ps = null;
    try {
            ps = con.prepareStatement(sql);
            ps.setString(1,origen );
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            ruta=new Ruta();
            ruta.setIdRuta(rs.getInt("idRuta"));
            ruta.setOrigen(rs.getString("origen"));
            ruta.setDestino(rs.getString("destino"));
            ruta.setDuracion_estimadad(rs.getTime("duracion_estimada").toLocalTime());
            ruta.setEstado(true);

            } else {
             JOptionPane.showMessageDialog(null, "No existe la ruta");
            }
            ps.close();
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ruta "+ex.getMessage());
            }
    return ruta;
}

public Ruta buscarRutaPorDestino(String destino){
    Ruta ruta = null;
    String sql = "SELECT `idRuta`, `origen`, `destino`, `duracion_estimada` FROM `ruta` WHERE destino = ? and estado = 1 ";
    PreparedStatement ps = null;
    try {
            ps = con.prepareStatement(sql);
            ps.setString(1,destino );
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            ruta=new Ruta();
            ruta.setIdRuta(rs.getInt("idRuta"));
            ruta.setOrigen(rs.getString("origen"));
            ruta.setDestino(rs.getString("destino"));
            ruta.setDuracion_estimadad(rs.getTime("duracion_estimada").toLocalTime());
            ruta.setEstado(true);

            } else {
             JOptionPane.showMessageDialog(null, "No existe la ruta");
            }
            ps.close();
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ruta "+ex.getMessage());
            }
    return ruta;
    

}

}


    
        
        
        
        
        
        
        
        
        
        
        
    

