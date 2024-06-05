package AccesosDatos;
import java.sql.Connection;
import Entidades.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
public class HorariosData {


     private Connection con=null;
     private RutaData ruta=new RutaData();

    public HorariosData() {
        con=Conexion.getConexion();
    }
     
    public void añadirHorario(Horario horario){
      String sql="INSERT INTO horario(`idRuta`, `hora_salida`, `hora_llegada`, `estado`) VALUES (?,?,?,?)"; 
      Time hora_salida=Time.valueOf(horario.getHora_salida());
      Time hora_llegada=Time.valueOf(horario.getHora_llegada());
      try{
           PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           ps.setInt(1, horario.getIdRuta().getIdRuta());
           ps.setTime(2, hora_salida);
           ps.setTime(3, hora_llegada);
           ps.setBoolean(4, horario.isEstado());
           ps.executeUpdate();
           
           ResultSet rs=ps.getGeneratedKeys();
           
           if(rs.next()){
           horario.setIdHorario(rs.getInt("idHorario"));
           JOptionPane.showMessageDialog(null, "Horario añadido con exito");
           }
           
           ps.close();
      }catch(SQLException e){
          JOptionPane.showMessageDialog(null, "Erro al acceder a la tabla horario "+e.getMessage());
      }
    }
    public List<Horario>obtenerHorarios(){
        String sql="SELECT `idHorario`, `idRuta`, `hora_salida`, `hora_llegada` FROM `horario` WHERE estado=1";
        List<Horario>horarios=new ArrayList();
           try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
               Horario hora =new Horario();
               hora.setIdHorario(rs.getInt("idHorario"));
               hora.setIdRuta(rs.get);
               hora.setHora_llegada(rs.getTime("hora_llegada").toLocalTime());
               hora.setHora_salida(rs.getTime("hora_salida").toLocalTime());
               hora.setEstado(rs.getBoolean("estado"));
               horarios.add(hora);
               
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Horarios y obtener sus horarios activos "+e.getMessage());
        }
        return horarios;
    }
    
    
    
    
    
    
    
    public List<Horario>listarHorariosPorRuta(int id_ruta){
        String sql="SELECT `hora_salida`, `hora_llegada` FROM `horario` WHERE idRuta=?";
        List<Horario>horarios=new ArrayList();
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id_ruta);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
            Horario hora=new Horario();
            hora.setIdHorario(rs.getInt("idHorario"));
            hora.setHora_salida(rs.getTime("hora_salida").toLocalTime());
            hora.setHora_llegada(rs.getTime("hora_llegada").toLocalTime());
            hora.setEstado(rs.getBoolean("estado"));
            hora.setIdRuta(ruta.);
            horarios.add(hora);
           }
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se puede acceder a la tabla horarios y recupera la lista de horarios por ruta "+e.getMessage());
        }
       return horarios; 
    }
}
