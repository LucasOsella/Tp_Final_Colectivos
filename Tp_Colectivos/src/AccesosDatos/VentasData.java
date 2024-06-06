package AccesosDatos;


import Entidades.Pasaje;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class VentasData {

private Connection con = null;

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
            ps.setTime(4, hora_viaje);
            ps.setDate(5, fecha_viaje);
            ps.setInt(6, pasaje.getAsiento());
            ps.setDouble(7, pasaje.getPrecio());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
                pasaje.setIdPasaje(rs.getInt("idPasaje"));
                JOptionPane.showMessageDialog(null, "Pasaje añadido con exito");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder al tabla pasaje "+e.getMessage());
        }        
    }
}
    

