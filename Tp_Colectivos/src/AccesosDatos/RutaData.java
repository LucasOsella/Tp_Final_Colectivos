package AccesosDatos;

import Entidades.Ruta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
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
    
    }    
        
        
        
        
        
        
        
        
        
        
        
        
        
    

