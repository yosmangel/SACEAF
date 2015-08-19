/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SancionesEquipoBdD;
import SancionesEquipoBdD.*;
import Basededatos.Conexion;
import java.sql.*;
import SancionesEquipoBdD.DatosSancionesEquipo;

public class InsertarSancionesEquipo {
    
    public boolean Insertar(DatosSancionesEquipo user)throws SQLException, ClassNotFoundException{
        
        Conexion parametros=new Conexion();
        Class.forName(parametros.getDriver());
        boolean result;
        try (Connection con = DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass()); Statement stm = con.createStatement()) {
            String query="Insert into sancion_equipo values ('"+user.getid_Sancion()+"','"+user.getMotivoSancion()+"','"+user.getFechasSuspension()+"','"+user.getid_equipo()+"')";
            result=stm.execute(query);
        }
        return result;
    }
                
}
