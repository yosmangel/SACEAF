/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Datosadministracion;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class municipio {

    public boolean Insertar(datosmunicipio user) throws SQLException, ClassNotFoundException{
   
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement stm=con.createStatement();
        boolean result;
        String query=("Insert Into municipio values('"+user.getSerial()+"', '"+user.getNombre()+"')");
        result=stm.execute(query);
        stm.close();
        con.close();
        return result;
    }
    
    public boolean Eliminar(datoeliminar user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement stm=con.createStatement();
        boolean result;
        String query=(" Delete from municipio where id_municipio=('"+user.getSerial()+"')");
        result=stm.execute(query);
        stm.close();
        con.close();
        return result;
    }
}
