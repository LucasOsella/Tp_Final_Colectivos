/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesosDatos;

import Entidades.Colectivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ColectivoData {
     private Connection con=null;
     
     public ColectivoData() {
    con= Conexion.getConexion();
}
     public void añadirColectivo (Colectivo colectivo){
      String sql = "INSERT INTO colectivo (`matricula`, `marca`, `modelo`, `capacidad`, `estado`)"
              + "VALUES(? ,? ,? ,? ,? ) ";
         try {
             PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
             ps.setString(1,colectivo.getMatricula());
             ps.setString(2,colectivo.getMarca());
             ps.setString(3,colectivo.getModelo());
             ps.setInt(4,colectivo.getCapacidad());
             ps.setBoolean(5,colectivo.isEstado());
            int registro = ps.executeUpdate();
             ResultSet rs =ps.getGeneratedKeys();
             if(rs.next()){
                 colectivo.setIdColectivo(rs.getInt(1));
                 JOptionPane.showMessageDialog(null,"Colectivo añadido");
             }
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla colectivo");
         }
     }
     public List<Colectivo> mostrarColectivos (){
         List<Colectivo> colectivos = new ArrayList();
         String sql = "SELECT * FROM colectivo";
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
              Colectivo bondi = new Colectivo ();
              bondi.setIdColectivo(rs.getInt("idColectivo"));
              bondi.setMatricula(rs.getString("matricula"));
              bondi.setMarca(rs.getString("marca"));
              bondi.setModelo(rs.getString("modelo"));
              bondi.setCapacidad(rs.getInt("capacidad"));
              bondi.setEstado(rs.getBoolean("estado"));
              colectivos.add(bondi);
             }
             ps.close();
                 
             
         } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al iniciar tabla colectivo.");
         }
     return colectivos;         
}
}