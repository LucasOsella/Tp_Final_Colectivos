package AccesosDatos;

import Entidades.*;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class PasajerosData {
    private Connection con=null;

    public PasajerosData() {
        con=Conexion.getConexion();
    }
    
    public void añadirPasajero(Pasajero pasajero){
       String sql="INSERT INTO `pasajero`(`nombre`, `apellido`, `dni`, `correo`, `telefono`, `estado`) VALUES (?,?,?,?,?,?)";
       
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,pasajero.getNombre());
            ps.setString(2, pasajero.getApellido());
            ps.setString(3, pasajero.getDni());
            ps.setString(4, pasajero.getCorreo());
            ps.setString(5, pasajero.getTelefono());
            ps.setBoolean(6, pasajero.isEstado());
            
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
                pasajero.setIdPasajero(rs.getInt("idPasajero"));
                JOptionPane.showMessageDialog(null, "Pasajero añadido con exito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla pasajero y añadir un pasajero "+e.getMessage());
        }
        
    }
    
    public List<Pasajero> listarPasajero(){      
       List<Pasajero>pasajeros=new ArrayList<>();
       String sql="SELECT `nombre`, `apellido`, `dni`, `correo`, `telefono` FROM `pasajero` WHERE estado=1";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();           
            while(rs.next()){
                Pasajero pas=new Pasajero();
                pas.setNombre(rs.getString("nombre"));
                pas.setApellido(rs.getString("apellido"));
                pas.setDni(rs.getString("dni"));
                pas.setCorreo(rs.getString("correo"));
                pas.setTelefono(rs.getString("telefono"));
                pasajeros.add(pas);
                
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puedo acceder a la tabla y listar todos los pasajeros activos "+e.getMessage());
        }
        return pasajeros;
    }
}
