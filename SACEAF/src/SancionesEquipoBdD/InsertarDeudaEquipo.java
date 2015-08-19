/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SancionesEquipoBdD;

import Basededatos.Conexion;
import java.sql.*;

public class InsertarDeudaEquipo {
    
    Conexion parametros = new Conexion();
    public boolean InsertarBdD(DatosDeudaEquipo user)throws SQLException,
            
    ClassNotFoundException{
        Class.forName(parametros.getDriver());
        Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement stm = con.createStatement();
        String query="INSERT INTO Deuda VALUES('"+user.getID_Deuda()+"','"+user.getFecha_Deuda()+"','"+user.getHora_Deuda()+"','"+user.getMotivo_Deuda()+"','"+user.getMonto_Deuda_Total()+"','"+user.getMonto_Deuda_Restante()+"','"+user.getID_Club()+"','"+user.getID_Equipo()+"')";
        boolean Result=stm.execute(query);
        stm.close();
        con.close();
        return Result;
    }        
}
