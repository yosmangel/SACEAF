/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SancionesJugadorBdD;
import Basededatos.Conexion;
import java.sql.*;
import SancionesJugadorBdD.DatosSancionesJugador;

public class InsertarSancionesJugador {
    
    public boolean Insertar(DatosSancionesJugador user)throws SQLException, ClassNotFoundException{
        
        Conexion parametros=new Conexion();
        Class.forName(parametros.getDriver());
        boolean result;
        try (Connection con = DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass()); Statement stm = con.createStatement()) {
            String query="Insert into sancion_jugador values ('"+user.getid_Sancion()+"','"+user.getMotivoSancion()+"','"+user.getFechasSuspension()+"','"+user.getCedula()+"')";
            result=stm.execute(query);
        }
        return result;
    }
                
}
